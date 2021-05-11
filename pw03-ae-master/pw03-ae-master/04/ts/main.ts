class shape {
  public height: number;
  public width: number;

  public area(): number {
    return null;
  }

  public perimeter(): number {
    return null;
  }
}

class circle extends shape {
  public radio: number;

  public area(): number {
    return Math.PI * this.radio * this.radio;
  }
}
