/**
 * GetAllQuery.java
 * Nov 2, 2011
 * Copyright 2009~2011 ESCA Mobile Ltd company, Inc. All rights reserved.
 * ESCA Mobile Ltd PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.robobinding.gallery.model.typedcursor;

import org.robobinding.internal.guava.Preconditions;
import org.robobinding.internal.guava.Strings;
import org.robobinding.itempresentationmodel.RowMapper;
import org.robobinding.itempresentationmodel.TypedCursor;
import org.robobinding.itempresentationmodel.TypedCursorAdapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * @since 1.0
 * @version $Revision:  $
 * @author Cheng Wei
 *
 */
public class GetAllQuery<T>
{
	private String tableName;
	private final RowMapper<T> rowMapper;

	public GetAllQuery(String tableName, RowMapper<T> rowMapper)
	{
	    Preconditions.checkNotNull(Strings.isNullOrEmpty(tableName), "table name cannot be empty");
	    Preconditions.checkNotNull(rowMapper, "row mapper cannot be null");

	    this.tableName = tableName;
	    this.rowMapper = rowMapper;
	}

	public TypedCursor<T> execute(SQLiteDatabase db)
	{
		Cursor cursor = db.query(
				tableName,
				null,
				null,
				null,
				null,
				null,
				BaseColumns._ID+" ASC");
		return new TypedCursorAdapter<T>(cursor, rowMapper);
	}
}