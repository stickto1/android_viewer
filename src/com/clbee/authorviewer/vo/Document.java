package com.clbee.authorviewer.vo;

import java.util.ArrayList;

public class Document {
	private ArrayList<Page> mDocument;

	public Document(ArrayList<Page> mDocument) {
		super();
		this.mDocument = new ArrayList<Page>();
		this.mDocument = mDocument;
	}

	public ArrayList<Page> getmDocument() {
		return mDocument;
	}

	public void setmDocument(ArrayList<Page> mDocument) {
		this.mDocument = mDocument;
	}
}
