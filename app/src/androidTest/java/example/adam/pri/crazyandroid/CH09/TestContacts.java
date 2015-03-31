package example.adam.pri.crazyandroid.CH09;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.test.AndroidTestCase;

/**
 * Created by lab on 2015/3/27.
 */
public class TestContacts extends AndroidTestCase{
    private static final String TAG = "=====  ContactTest  =====";

    public void testGetContacts(){
        System.out.println(TAG+" Test Get Contacts");
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        ContentResolver contentResolver = getContext().getContentResolver();

        Cursor cursor = contentResolver.query(uri,null,null,null,null);
//        cursor.moveToFirst();
        StringBuilder sb = new StringBuilder();
        while(cursor.moveToNext()){
            String contactId = cursor.getString(cursor.getColumnIndex(
                    ContactsContract.Contacts._ID
            ));
            String name = cursor.getString(cursor.getColumnIndex(
                    ContactsContract.Contacts.DISPLAY_NAME
            ));

            sb.append("_ID = "+contactId).append("DISPLAY_NAME = "+name);
            Cursor phoneCursor = contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+contactId,
                    null,null
            );
//            phoneCursor.moveToFirst();
            while(phoneCursor.moveToNext()){
                String phoneNumber = cursor.getString(cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                ));
                sb.append(" Number = "+phoneNumber);
            }
            sb.append("\n");
        }

        System.err.println(sb.toString());
    }

    public void testInsert(){
        ContentValues contentValues = new ContentValues();
        Uri contactsUri = getContext().getContentResolver().
                insert(ContactsContract.RawContacts.CONTENT_URI, contentValues);
        long rawId = ContentUris.parseId(contactsUri);
        contentValues.clear();

        contentValues.put(ContactsContract.Contacts.Data.RAW_CONTACT_ID,rawId);
        contentValues.put(ContactsContract.Contacts.Data.MIMETYPE,
                ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
    }
}
