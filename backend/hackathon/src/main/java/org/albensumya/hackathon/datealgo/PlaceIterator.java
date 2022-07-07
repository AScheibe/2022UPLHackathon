package org.albensumya.hackathon.datealgo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PlaceIterator implements Iterator<Place> {
  private PlaceQueue queue;

  public PlaceIterator(PlaceQueue queue) {
    this.queue = queue.deepCopy();
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  @Override
  public Place next() {
    if (!hasNext())
      throw new NoSuchElementException("No more places in this iteration");
    return queue.dequeue();
  }
}
