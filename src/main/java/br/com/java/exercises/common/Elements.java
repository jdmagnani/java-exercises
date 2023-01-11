package br.com.java.exercises.common;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class Elements<Type> implements Iterable<Type> {

	private int maxNumber;

	public Elements(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	@Override
	public Iterator<Type> iterator() {
		Iterator<String> it = new Iterator<String>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < Elements.this.maxNumber;
			}

			@Override
			public String next() {
				this.currentIndex++;
				if (this.currentIndex % 3 != 0 && this.currentIndex % 5 != 0) {
					return this.currentIndex + "";
				}
				List<String> output = new ArrayList<String>();
				if (this.currentIndex % 3 == 0) {
					output.add("Visual");
				}
				if (this.currentIndex % 5 == 0) {
					output.add("Nuts");
				}
				return String.join(" ", output);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

		return (Iterator<Type>) it;
	}

}
