/*     */ package snake2d.util.file;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.file.Path;
/*     */ import java.util.zip.DeflaterOutputStream;
/*     */ import snake2d.util.misc.ACTION;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FilePutter
/*     */ {
/*     */   private final OutputStream out;
/*     */   private final ObjectOutputStream object;
/*     */   private final ByteBuffer buffer;
/*     */   public final Path path;
/*     */   private volatile Exception ex;
/*     */   private volatile boolean working;
/*     */   
/*     */   public FilePutter(Path path, int size) {
/*  56 */     this.working = false; this.buffer = ByteBuffer.allocate(size); this.path = path; this.out = new ByteBufferBackedOutputStream(this.buffer); try {
/*     */       this.object = new ObjectOutputStream(this.out); this.object.flush();
/*     */     } catch (IOException e) {
/*     */       throw new RuntimeException(e);
/*  60 */     }  } public boolean zip(ACTION checkin) { final Thread current = Thread.currentThread();
/*     */     
/*  62 */     this.ex = null;
/*  63 */     this.working = true;
/*     */     
/*  65 */     Thread t = new Thread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try {
/*  70 */               FilePutter.this.object.flush();
/*  71 */               File f = new File((String)FilePutter.this.path);
/*  72 */               f.createNewFile();
/*  73 */               f.setWritable(true);
/*     */ 
/*     */               
/*  76 */               FileOutputStream out = new FileOutputStream(f);
/*  77 */               DeflaterOutputStream defl = new DeflaterOutputStream(out, true);
/*  78 */               FilePutter.this.buffer.flip();
/*     */               
/*  80 */               ByteBuffer b = ByteBuffer.allocate(4);
/*  81 */               b.putInt(FilePutter.this.buffer.limit());
/*  82 */               b.flip();
/*  83 */               defl.write(b.array());
/*  84 */               defl.flush();
/*     */               
/*  86 */               defl.write(FilePutter.this.buffer.array(), 0, FilePutter.this.buffer.limit());
/*  87 */               defl.flush();
/*  88 */               defl.close();
/*     */               
/*  90 */               out.close();
/*  91 */               FilePutter.this.working = false;
/*  92 */             } catch (IOException e1) {
/*  93 */               FilePutter.this.ex = e1;
/*  94 */               FilePutter.this.working = false;
/*  95 */               current.interrupt();
/*  96 */               e1.printStackTrace();
/*  97 */               throw new RuntimeException(e1);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 102 */     t.setName("zipper");
/* 103 */     t.start();
/*     */ 
/*     */     
/* 106 */     long m = System.currentTimeMillis();
/* 107 */     long check = 0L;
/*     */     
/* 109 */     while (System.currentTimeMillis() - m < 10000L && this.working) {
/* 110 */       Thread.yield();
/* 111 */       if (check != (System.currentTimeMillis() - m) / 1000L) {
/* 112 */         check = (System.currentTimeMillis() - m) / 100L;
/* 113 */         checkin.exe();
/*     */       } 
/*     */     } 
/*     */     
/* 117 */     if (this.working) {
/* 118 */       System.err.println("saver thread took too long to save...");
/*     */     }
/*     */     
/* 121 */     if (this.ex != null) {
/* 122 */       this.ex.printStackTrace();
/* 123 */       throw new RuntimeException(this.ex);
/*     */     } 
/*     */     
/* 126 */     return true; }
/*     */   public void save() { try { this.object.flush(); File f = new File((String)this.path); f.createNewFile(); FileOutputStream outfile = new FileOutputStream(f); this.buffer.flip(); outfile.getChannel().write(this.buffer); outfile.flush(); outfile.close(); }
/*     */     catch (IOException e1)
/*     */     { throw new RuntimeException(e1); }
/* 130 */      } public FilePutter bool(boolean bool) { b((byte)(bool ? 1 : 0));
/* 131 */     return this; }
/*     */ 
/*     */   
/*     */   public void mark(String s) {
/* 135 */     i(s.hashCode());
/*     */   }
/*     */   
/*     */   public void mark(Class<?> c) {
/* 139 */     mark(c.getSimpleName());
/*     */   }
/*     */   
/*     */   public void mark(Object o) {
/* 143 */     mark(o.getClass().getSimpleName());
/*     */   }
/*     */   
/*     */   public void object(Object o) {
/*     */     try {
/* 148 */       int pos = getPosition();
/* 149 */       i(0);
/* 150 */       this.object.writeObject(o);
/* 151 */       this.object.flush();
/* 152 */       int npos = getPosition();
/* 153 */       int l = getPosition() - pos;
/* 154 */       this.buffer.position(pos);
/* 155 */       i(l);
/* 156 */       this.buffer.position(npos);
/* 157 */     } catch (IOException e) {
/* 158 */       System.err.println(o);
/* 159 */       System.err.println(o.getClass());
/* 160 */       System.err.println(o.getClass().getName());
/* 161 */       throw new RuntimeException(o + " " + e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public FilePutter i(int i) {
/* 166 */     writeInt(i);
/* 167 */     return this;
/*     */   }
/*     */   
/*     */   public FilePutter b(byte b) {
/* 171 */     this.buffer.put(b);
/* 172 */     return this;
/*     */   }
/*     */   
/*     */   public FilePutter l(long l) {
/* 176 */     this.buffer.putLong(l);
/* 177 */     return this; } public FilePutter ls(long[] ls) {
/*     */     byte b;
/*     */     int i;
/*     */     long[] arrayOfLong;
/* 181 */     for (i = (arrayOfLong = ls).length, b = 0; b < i; ) { long l = arrayOfLong[b];
/* 182 */       this.buffer.putLong(l); b++; }
/* 183 */      return this;
/*     */   }
/*     */   
/*     */   public void lsE(long[] tiles) {
/* 187 */     i(tiles.length);
/* 188 */     ls(tiles);
/*     */   } public FilePutter ls(long[][] ls) { byte b;
/*     */     int i;
/*     */     long[][] arrayOfLong;
/* 192 */     for (i = (arrayOfLong = ls).length, b = 0; b < i; ) { long[] l = arrayOfLong[b];
/* 193 */       ls(l); b++; }
/* 194 */      return this; } public void writeArray(short[][] tiles) {
/*     */     byte b;
/*     */     int i;
/*     */     short[][] arrayOfShort;
/* 198 */     for (i = (arrayOfShort = tiles).length, b = 0; b < i; ) { short[] sa = arrayOfShort[b];
/* 199 */       ss(sa);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/* 204 */   public FilePutter s(short s) { this.buffer.putShort(s);
/* 205 */     return this; } public void ss(short[] tiles) {
/*     */     byte b;
/*     */     int i;
/*     */     short[] arrayOfShort;
/* 209 */     for (i = (arrayOfShort = tiles).length, b = 0; b < i; ) { short s = arrayOfShort[b];
/* 210 */       this.buffer.putShort(s);
/*     */       b++; }
/*     */   
/*     */   }
/* 214 */   public void ssE(short[] tiles) { i(tiles.length); byte b; int i; short[] arrayOfShort;
/* 215 */     for (i = (arrayOfShort = tiles).length, b = 0; b < i; ) { short s = arrayOfShort[b];
/* 216 */       this.buffer.putShort(s); b++; }
/*     */      } public void is(int[] tiles) { byte b;
/*     */     int i;
/*     */     int[] arrayOfInt;
/* 220 */     for (i = (arrayOfInt = tiles).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 221 */       this.buffer.putInt(j);
/*     */       b++; }
/*     */      }
/*     */   
/* 225 */   public void isE(int[] tiles) { i(tiles.length); byte b; int i, arrayOfInt[];
/* 226 */     for (i = (arrayOfInt = tiles).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 227 */       this.buffer.putInt(j); b++; }
/*     */      } public void ds(double[] tiles) { byte b;
/*     */     int i;
/*     */     double[] arrayOfDouble;
/* 231 */     for (i = (arrayOfDouble = tiles).length, b = 0; b < i; ) { double d = arrayOfDouble[b];
/* 232 */       this.buffer.putDouble(d);
/*     */       b++; }
/*     */      }
/*     */    public void dsE(double[] tiles) {
/* 236 */     i(tiles.length); byte b; int i; double[] arrayOfDouble;
/* 237 */     for (i = (arrayOfDouble = tiles).length, b = 0; b < i; ) { double d = arrayOfDouble[b];
/* 238 */       this.buffer.putDouble(d);
/*     */       b++; }
/*     */   
/*     */   } public void save(SAVABLE ss) {
/* 242 */     int pos = getPosition();
/* 243 */     i(0);
/* 244 */     ss.save(this);
/* 245 */     int le = getPosition() - pos - 4;
/* 246 */     setAtPosition(pos, le);
/*     */   } public void fs(float[] data) {
/*     */     byte b;
/*     */     int i;
/*     */     float[] arrayOfFloat;
/* 251 */     for (i = (arrayOfFloat = data).length, b = 0; b < i; ) { float f = arrayOfFloat[b];
/* 252 */       this.buffer.putFloat(f);
/*     */       b++; }
/*     */   
/*     */   } public void fsE(float[] data) {
/* 256 */     i(data.length); byte b; int i; float[] arrayOfFloat;
/* 257 */     for (i = (arrayOfFloat = data).length, b = 0; b < i; ) { float f = arrayOfFloat[b];
/* 258 */       this.buffer.putFloat(f);
/*     */       b++; }
/*     */   
/*     */   } public void f(float f) {
/* 262 */     this.buffer.putFloat(f);
/*     */   } public void is(int[][] tiles) {
/*     */     byte b;
/*     */     int i;
/*     */     int[][] arrayOfInt;
/* 267 */     for (i = (arrayOfInt = tiles).length, b = 0; b < i; ) { int[] sa = arrayOfInt[b];
/* 268 */       is(sa);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/* 273 */   public void isE(int[][] tiles) { i(tiles.length); byte b; int i, arrayOfInt[][];
/* 274 */     for (i = (arrayOfInt = tiles).length, b = 0; b < i; ) { int[] arrayOfInt1 = arrayOfInt[b];
/* 275 */       isE(arrayOfInt1); b++; }
/*     */      } public void bs(byte[][] bytes) { byte b;
/*     */     int i;
/*     */     byte[][] arrayOfByte;
/* 279 */     for (i = (arrayOfByte = bytes).length, b = 0; b < i; ) { byte[] sa = arrayOfByte[b];
/* 280 */       bs(sa);
/*     */       b++; }
/*     */      }
/*     */   
/*     */   public void bs(byte[] sa) {
/* 285 */     this.buffer.put(sa);
/*     */   }
/*     */   
/*     */   public void bsE(byte[] sa) {
/* 289 */     i(sa.length);
/* 290 */     this.buffer.put(sa);
/*     */   }
/*     */   
/*     */   public void writeInt(int i) {
/* 294 */     this.buffer.putInt(i);
/*     */   }
/*     */   
/*     */   public FilePutter d(double d) {
/* 298 */     this.buffer.putDouble(d);
/* 299 */     return this;
/*     */   }
/*     */   
/*     */   public int writtenInts() {
/* 303 */     return this.buffer.position() / 4;
/*     */   }
/*     */   
/*     */   public int getPosition() {
/* 307 */     return this.buffer.position();
/*     */   }
/*     */   
/*     */   public void setAtPosition(int pos, int value) {
/* 311 */     int p = this.buffer.position();
/* 312 */     this.buffer.position(pos);
/* 313 */     i(value);
/* 314 */     this.buffer.position(p);
/*     */   }
/*     */   
/*     */   public void chars(CharSequence c) {
/* 318 */     i(0);
/* 319 */     i(c.length());
/* 320 */     for (int i = 0; i < c.length(); i++) {
/* 321 */       this.buffer.putShort((short)c.charAt(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void charss(CharSequence[] cc) {
/* 326 */     i(0);
/* 327 */     i(cc.length);
/* 328 */     for (int i = 0; i < cc.length; i++)
/* 329 */       chars(cc[i]); 
/*     */   }
/*     */   
/*     */   private static class ByteBufferBackedOutputStream
/*     */     extends OutputStream {
/*     */     ByteBuffer buf;
/*     */     
/*     */     ByteBufferBackedOutputStream(ByteBuffer buf) {
/* 337 */       this.buf = buf;
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(int b) throws IOException {
/* 342 */       this.buf.put((byte)b);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(byte[] bytes, int off, int len) throws IOException {
/* 347 */       this.buf.put(bytes, off, len);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\FilePutter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */