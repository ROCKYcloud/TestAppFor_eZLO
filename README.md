# TestAppFor_eZLO
added JUnit Test
added dataBase "Room"
- [x] The list must be sorted by PK_Device(this is the same with SN from the mocks) and must have a header with a picture and your name.
The item icon is displayed depending on "Platform"
- [x] List Item titles should be generated
- [x] On the item click open a new page that has the same header and the item details.
- [x] On item Long click a dialog must be displayed with the delete option and two buttons ok and cancel. On delete selected the item must be removed from the list, on cancel the user must see the same list.
- [x] Put an edit Icon somewhere on the list items and when click on it, open the same detail page with Edit Mode. (In edit mode, Only the Title field -Home Number 1–  should be editable. The user expects to see the title in an EditText and the keyboard is visible). There should be a way to save changes. When the user back to the list page, the related item should be refreshed with new values.
- [ ] The fetched list should be stored by using a database. A “Reset”  button should be located on the top of the screen. And the button should provide a way to fetch the data from the API and reset the items on the db and on the list.
