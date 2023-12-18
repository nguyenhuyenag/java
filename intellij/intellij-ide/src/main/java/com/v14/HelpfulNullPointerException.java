package com.v14;

/*-
 * String name = jd.getBlog().getAuthor()
 *
 * - Before v14
 * Exception in thread "main" java.lang.NullPointerException
 * 		at NullPointerExample.main(NullPointerExample.java:5)
 *
 * - For v14
 * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Blog.getAuthor()"
 * because the return value of "Journaldev.getBlog()" is null
 * 		at NullPointerExample.main(NullPointerExample.java:4)
 */
public class HelpfulNullPointerException {

}
