delete from SEQUENCE;

delete from BOOK_LIBRARYUSER;
delete from BOOKBORROW;

delete from BOOKITEM;
delete from PERIODICALITEM;
delete from PUBLICATIONITEM;

delete from BOOKORDER;

delete from BOOK;
delete from PERIODICAL;
delete from PUBLICATION;

delete from LIBRARYUSER;

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'SEQUENCE','C:\LMS\DB\DATA\Sequence.dat', '; ','%', 'KSC5601', 0);


CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'LIBRARYUSER','C:\LMS\DB\DATA\LibraryUser.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'PUBLICATION','C:\LMS\DB\DATA\Publication.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'PERIODICAL','C:\LMS\DB\DATA\Periodical.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'BOOK','C:\LMS\DB\DATA\Book.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'BOOKORDER','C:\LMS\DB\DATA\BookOrder.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'PUBLICATIONITEM','C:\LMS\DB\DATA\PublicationItem.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'PERIODICALITEM','C:\LMS\DB\DATA\PeriodicalItem.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'BOOKITEM','C:\LMS\DB\DATA\BookItem.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'BOOKBORROW','C:\LMS\DB\DATA\BookBorrow.dat', '; ','%', 'KSC5601', 0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE 
   (null,'BOOK_LIBRARYUSER','C:\LMS\DB\DATA\Book_LibraryUser.dat', '; ','%', 'KSC5601', 0);






