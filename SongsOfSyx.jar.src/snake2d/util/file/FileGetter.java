/*     */ package snake2d.util.file;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Arrays;
/*     */ import java.util.zip.InflaterInputStream;
/*     */ 
/*     */ 
/*     */ public final class FileGetter
/*     */ {
/*     */   public final Path path;
/*     */   private final ObjectInputStream object;
/*     */   private final ByteBuffer buffer;
/*     */   
/*     */   public FileGetter(Path path) throws IOException {
/*  24 */     this.path = path;
/*  25 */     File f = new File((String)path);
/*  26 */     if (!f.isFile() || f.length() == 0L) {
/*  27 */       throw new IOException(
/*  28 */           "file is corrupt. Try replacing it from an uncorrupted game folder, or delete it and see what happens " + 
/*  29 */           f.isFile() + " " + f.length() + " " + path);
/*     */     }
/*     */     
/*  32 */     if (f.length() > 2147483647L) {
/*  33 */       throw new RuntimeException("file too large to read");
/*     */     }
/*  35 */     this.buffer = ByteBuffer.allocate((int)f.length());
/*     */     
/*     */     try {
/*  38 */       FileInputStream in = new FileInputStream(f);
/*  39 */       FileChannel channel = in.getChannel();
/*  40 */       channel.read(this.buffer);
/*  41 */       channel.close();
/*  42 */       in.close();
/*  43 */       this.buffer.flip();
/*  44 */       InputStream inn = new ByteBufferBackedInputStream(this.buffer);
/*  45 */       this.object = new ObjectInputStream(inn);
/*     */     }
/*  47 */     catch (Exception e) {
/*  48 */       e.printStackTrace();
/*  49 */       throw new IOException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public FileGetter(Path path, boolean zipped) throws IOException {
/*  54 */     this.path = path;
/*  55 */     File f = new File((String)path);
/*  56 */     if (!Files.exists(path, new java.nio.file.LinkOption[0]) || !Files.isReadable(path)) {
/*  57 */       throw new IOException(
/*  58 */           " file is corrupt. Try replacing it from an uncorrupted game folder, or delete it and see what happens " + 
/*  59 */           path);
/*     */     }
/*     */     
/*  62 */     if (f.length() > 2147483647L) {
/*  63 */       throw new RuntimeException("file too large to read");
/*     */     }
/*     */     try {
/*  66 */       InputStream in = Files.newInputStream(path, new java.nio.file.OpenOption[0]);
/*  67 */       InflaterInputStream zip = new InflaterInputStream(in);
/*  68 */       byte[] data = Alloc.bb(4);
/*  69 */       zip.read(data);
/*  70 */       ByteBuffer size = ByteBuffer.wrap(data);
/*  71 */       data = Alloc.bb(size.getInt());
/*  72 */       int kk = 0;
/*  73 */       while (kk >= 0 && kk < data.length) {
/*  74 */         kk += zip.read(data, kk, data.length - kk);
/*     */       }
/*  76 */       zip.close();
/*  77 */       in.close();
/*  78 */       this.buffer = ByteBuffer.wrap(data);
/*  79 */       InputStream inn = new ByteBufferBackedInputStream(this.buffer);
/*  80 */       this.object = new ObjectInputStream(inn);
/*     */     }
/*  82 */     catch (Exception e) {
/*  83 */       f.delete();
/*  84 */       throw new IOException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void close() {
/*     */     try {
/*  90 */       this.object.close();
/*  91 */     } catch (IOException e) {
/*  92 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object object(boolean acceptNull) throws IOException {
/*  98 */     int pp = getPosition() + i();
/*     */     try {
/* 100 */       return this.object.readObject();
/* 101 */     } catch (Exception e) {
/* 102 */       if (acceptNull) {
/* 103 */         setPosition(pp);
/* 104 */         return null;
/*     */       } 
/* 106 */       throw new IOException("A code artefact is missing in the current configuration of the game. The usual suspect is a mod version change. Contact the modder in question.", e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object object() throws IOException {
/* 111 */     return object(false);
/*     */   }
/*     */   
/*     */   public void check(String s) throws IOException {
/* 115 */     int i = i();
/* 116 */     int h = s.hashCode();
/* 117 */     if (i != h) {
/* 118 */       throw new IOException("corrupt data, expecting : " + s + " (" + h + ", " + i + "), " + this.path);
/*     */     }
/*     */   }
/*     */   
/*     */   public void check(Object o) throws IOException {
/* 123 */     check(o.getClass().getSimpleName());
/*     */   } public void readArray(short[][] shorts) throws IOException {
/*     */     byte b;
/*     */     int i;
/*     */     short[][] arrayOfShort;
/* 128 */     for (i = (arrayOfShort = shorts).length, b = 0; b < i; ) { short[] s = arrayOfShort[b];
/* 129 */       ss(s);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void ss(short[] shorts) throws IOException {
/* 135 */     for (int i = 0; i < shorts.length; i++)
/* 136 */       shorts[i] = s(); 
/*     */   }
/*     */   
/*     */   public void ssE(short[] data) throws IOException {
/* 140 */     int l = i();
/* 141 */     checkLength(l, data.length);
/* 142 */     if (l != data.length) {
/* 143 */       short[] b = new short[l];
/* 144 */       ss(b);
/* 145 */       for (int i = 0; i < l && i < data.length; i++)
/* 146 */         data[i] = b[i]; 
/*     */     } else {
/* 148 */       ss(data);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void is(int[] data) throws IOException {
/* 153 */     for (int i = 0; i < data.length; i++)
/* 154 */       data[i] = i(); 
/*     */   }
/*     */   
/*     */   public boolean isE(int[] data) throws IOException {
/* 158 */     int l = i();
/* 159 */     if (l != data.length) {
/* 160 */       int[] b = Alloc.ii(l);
/* 161 */       is(b);
/* 162 */       for (int i = 0; i < l && i < data.length; i++)
/* 163 */         data[i] = b[i]; 
/* 164 */       return false;
/*     */     } 
/* 166 */     is(data);
/* 167 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ds(double[] data) throws IOException {
/* 173 */     for (int i = 0; i < data.length; i++)
/* 174 */       data[i] = d(); 
/*     */   }
/*     */   
/*     */   public void dsE(double[] data) throws IOException {
/* 178 */     int l = i();
/* 179 */     if (l != data.length) {
/* 180 */       double[] b = new double[l];
/* 181 */       ds(b);
/* 182 */       for (int i = 0; i < l && i < data.length; i++)
/* 183 */         data[i] = b[i]; 
/*     */     } else {
/* 185 */       ds(data);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void fs(float[] data) {
/* 190 */     for (int i = 0; i < data.length; i++)
/* 191 */       data[i] = f(); 
/*     */   }
/*     */   
/*     */   public void fsE(float[] data) throws IOException {
/* 195 */     int l = i();
/* 196 */     if (l != data.length) {
/* 197 */       float[] b = new float[l];
/* 198 */       fs(b);
/* 199 */       for (int i = 0; i < l && i < data.length; i++)
/* 200 */         data[i] = b[i]; 
/*     */     } else {
/* 202 */       fs(data);
/*     */     } 
/*     */   }
/*     */   public float f() {
/* 206 */     return this.buffer.getFloat();
/*     */   } public void is(int[][] data) throws IOException {
/*     */     byte b;
/*     */     int i;
/*     */     int[][] arrayOfInt;
/* 211 */     for (i = (arrayOfInt = data).length, b = 0; b < i; ) { int[] arrayOfInt1 = arrayOfInt[b];
/* 212 */       is(arrayOfInt1);
/*     */       b++; }
/*     */   
/*     */   } public void isE(int[][] data) throws IOException {
/* 216 */     int l = i();
/* 217 */     checkLength(l, data.length);
/* 218 */     for (int i = 0; i < l; i++) {
/* 219 */       if (i < data.length) {
/* 220 */         isE(data[i]);
/*     */       } else {
/* 222 */         isE(Alloc.ii(0));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void readArray(int[][] shorts) throws IOException { byte b;
/*     */     int i;
/*     */     int[][] arrayOfInt;
/* 230 */     for (i = (arrayOfInt = shorts).length, b = 0; b < i; ) { int[] s = arrayOfInt[b];
/* 231 */       is(s);
/*     */       b++; }
/*     */      } public void bs(byte[][] bytes) throws IOException { byte b;
/*     */     int i;
/*     */     byte[][] arrayOfByte;
/* 236 */     for (i = (arrayOfByte = bytes).length, b = 0; b < i; ) { byte[] s = arrayOfByte[b];
/* 237 */       bs(s);
/*     */       b++; }
/*     */      }
/*     */    public void bs(byte[] bytes) throws IOException {
/*     */     try {
/* 242 */       this.buffer.get(bytes);
/* 243 */     } catch (BufferUnderflowException e) {
/* 244 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public byte b() throws IOException {
/* 249 */     if (this.buffer.remaining() < 1)
/* 250 */       throw new IOException(); 
/* 251 */     return this.buffer.get();
/*     */   }
/*     */   
/*     */   public void bsE(byte[] bytes) throws IOException {
/* 255 */     int l = i();
/* 256 */     checkLength(l, bytes.length);
/* 257 */     if (l != bytes.length) {
/* 258 */       byte[] b = Alloc.bb(l);
/* 259 */       bs(b);
/* 260 */       for (int i = 0; i < l && i < bytes.length; i++)
/* 261 */         bytes[i] = b[i]; 
/*     */     } else {
/* 263 */       bs(bytes);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastInt() throws IOException {
/* 272 */     if (this.buffer.remaining() <= 4)
/* 273 */       throw new IOException(); 
/* 274 */     int res = this.buffer.getInt(this.buffer.limit() - 4);
/* 275 */     return res;
/*     */   }
/*     */   
/*     */   public int lastInt(int off) throws IOException {
/* 279 */     if (this.buffer.remaining() <= 4)
/* 280 */       throw new IOException(); 
/* 281 */     int res = this.buffer.getInt(this.buffer.limit() - 4 * off);
/* 282 */     return res;
/*     */   }
/*     */   
/*     */   public int remainingInts() {
/* 286 */     return this.buffer.remaining() / 4;
/*     */   }
/*     */   
/*     */   public int currentInt() {
/* 290 */     return this.buffer.position() / 4;
/*     */   }
/*     */   
/*     */   public int i() throws IOException {
/* 294 */     if (this.buffer.remaining() < 4)
/* 295 */       throw new IOException(); 
/* 296 */     return this.buffer.getInt();
/*     */   }
/*     */   
/*     */   public double d() throws IOException {
/* 300 */     if (this.buffer.remaining() <= 8)
/* 301 */       throw new IOException(); 
/* 302 */     return this.buffer.getDouble();
/*     */   }
/*     */   
/*     */   public String[] charss() throws IOException {
/* 306 */     test(0);
/* 307 */     int k = i();
/* 308 */     if (k < 0)
/* 309 */       throw new IOException(); 
/* 310 */     if (k > 1000000)
/* 311 */       throw new IOException(); 
/* 312 */     String[] rr = new String[k];
/* 313 */     for (int i = 0; i < rr.length; i++) {
/* 314 */       rr[i] = chars();
/*     */     }
/* 316 */     return rr;
/*     */   }
/*     */   
/*     */   public String chars() throws IOException {
/* 320 */     test(0);
/* 321 */     int k = i();
/* 322 */     if (k < 0)
/* 323 */       throw new IOException(); 
/* 324 */     if (k > 1000000)
/* 325 */       throw new IOException(); 
/* 326 */     char[] chars = new char[k];
/* 327 */     for (int i = 0; i < chars.length; i++) {
/* 328 */       if (!this.buffer.hasRemaining())
/* 329 */         throw new IOException(); 
/* 330 */       chars[i] = (char)(this.buffer.getShort() & 0xFF);
/*     */     } 
/* 332 */     return new String(chars);
/*     */   }
/*     */   
/*     */   public boolean test(int i) throws IOException {
/* 336 */     int q = i();
/* 337 */     if (q == i)
/* 338 */       return true; 
/* 339 */     this.buffer.position(this.buffer.position() - 4);
/* 340 */     return false;
/*     */   }
/*     */   
/*     */   public short s() throws IOException {
/* 344 */     if (this.buffer.remaining() < 2)
/* 345 */       throw new IOException(); 
/* 346 */     return this.buffer.getShort();
/*     */   }
/*     */   
/*     */   private static class ByteBufferBackedInputStream
/*     */     extends InputStream {
/*     */     ByteBuffer buf;
/*     */     
/*     */     ByteBufferBackedInputStream(ByteBuffer buf) {
/* 354 */       this.buf = buf;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read() {
/* 359 */       if (!this.buf.hasRemaining()) {
/* 360 */         return -1;
/*     */       }
/* 362 */       return this.buf.get();
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(byte[] bytes, int off, int len) {
/* 367 */       len = Math.min(len, this.buf.remaining());
/* 368 */       this.buf.get(bytes, off, len);
/* 369 */       return len;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean bool() throws IOException {
/* 374 */     return (b() == 1);
/*     */   }
/*     */   
/*     */   public long l() {
/* 378 */     return this.buffer.getLong();
/*     */   }
/*     */   
/*     */   public void ls(long[] ls) {
/* 382 */     for (int i = 0; i < ls.length; i++)
/* 383 */       ls[i] = this.buffer.getLong(); 
/*     */   }
/*     */   
/*     */   public boolean lsE(long[] ls) throws IOException {
/* 387 */     int l = i();
/* 388 */     checkLength(l, ls.length);
/* 389 */     if (l != ls.length) {
/* 390 */       ls(new long[l]);
/* 391 */       Arrays.fill(ls, 0L);
/* 392 */       return true;
/*     */     } 
/* 394 */     ls(ls);
/* 395 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkLength(int l, int old) throws IOException {
/* 401 */     if (l == 0)
/*     */       return; 
/* 403 */     if (l < 0)
/* 404 */       throw new IOException(); 
/* 405 */     if (l != old)
/*     */     {
/* 407 */       if (l / old > 10 || old / l > 10)
/* 408 */         throw new IOException(); 
/*     */     }
/*     */   }
/*     */   
/*     */   public void ls(long[][] ls) {
/* 413 */     for (int i = 0; i < ls.length; i++)
/* 414 */       ls(ls[i]); 
/*     */   }
/*     */   
/*     */   public void load(SAVABLE saver) throws IOException {
/* 418 */     int le = i();
/* 419 */     if (saver == null) {
/* 420 */       setPosition(getPosition() + le);
/*     */     } else {
/* 422 */       saver.load(this);
/*     */     } 
/*     */   }
/*     */   public int getPosition() {
/* 426 */     return this.buffer.position();
/*     */   }
/*     */   
/*     */   public void setPosition(int pos) {
/* 430 */     this.buffer.position(pos);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\FileGetter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */