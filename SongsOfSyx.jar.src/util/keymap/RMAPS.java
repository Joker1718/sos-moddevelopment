/*     */ package util.keymap;
/*     */ 
/*     */ import game.save.Savable;
/*     */ import init.INIT;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public class RMAPS<T extends MAPPED>
/*     */   extends RMAP<T>
/*     */ {
/*     */   private Saver saver;
/*     */   private Loader loader;
/*     */   
/*     */   public RMAPS(String key, LIST<T> all) {
/*  21 */     super(key, all);
/*  22 */     INIT.addSaver(new Savable(key)
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/*  26 */             RMAPS.this.saver = new RMAPS.Saver(file);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/*  32 */             RMAPS.this.loader = new RMAPS.Loader(file);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Saver saver() {
/*  43 */     return this.saver;
/*     */   }
/*     */ 
/*     */   
/*     */   public Loader loader() {
/*  48 */     return this.loader;
/*     */   }
/*     */   
/*     */   public final class Saver
/*     */   {
/*     */     private Saver(FilePutter f) {
/*  54 */       f.mark(RMAPS.this);
/*  55 */       f.i(RMAPS.this.all().size());
/*  56 */       for (MAPPED mAPPED : RMAPS.this.all()) {
/*  57 */         f.chars(mAPPED.key());
/*     */       }
/*  59 */       f.mark(RMAPS.this);
/*     */     }
/*     */     
/*     */     public void save(T t, FilePutter f) {
/*  63 */       if (t == null) {
/*  64 */         f.i(-1);
/*     */       } else {
/*  66 */         f.i(t.index());
/*     */       } 
/*     */     }
/*     */     public void save(int[] amounts, FilePutter f) {
/*  70 */       RMAPS.this.check(amounts.length);
/*  71 */       f.is(amounts);
/*     */     }
/*     */     
/*     */     public void save(short[] amounts, FilePutter f) {
/*  75 */       RMAPS.this.check(amounts.length);
/*  76 */       f.ss(amounts);
/*     */     }
/*     */     
/*     */     public void save(SAVABLE[] amounts, FilePutter f) {
/*  80 */       RMAPS.this.check(amounts.length); byte b; int i; SAVABLE[] arrayOfSAVABLE;
/*  81 */       for (i = (arrayOfSAVABLE = amounts).length, b = 0; b < i; ) { SAVABLE s = arrayOfSAVABLE[b];
/*  82 */         s.save(f);
/*     */         b++; }
/*     */     
/*     */     } public void save(LIST<? extends SAVABLE> amounts, FilePutter f) {
/*  86 */       RMAPS.this.check(amounts.size());
/*  87 */       for (SAVABLE s : amounts)
/*  88 */         s.save(f); 
/*     */     }
/*     */     
/*     */     public void save(double[] amounts, FilePutter f) {
/*  92 */       RMAPS.this.check(amounts.length);
/*  93 */       f.ds(amounts);
/*     */     }
/*     */     
/*     */     public void save(long[] amounts, FilePutter f) {
/*  97 */       RMAPS.this.check(amounts.length);
/*  98 */       f.ls(amounts);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void check(int ams) {
/* 104 */     if (ams != all().size())
/* 105 */       throw new RuntimeException("" + ams + " " + ams); 
/*     */   }
/*     */   
/*     */   public final class Loader
/*     */   {
/*     */     private final boolean isSame;
/*     */     private final int am;
/*     */     private final int[] order;
/*     */     
/*     */     private Loader(FileGetter f) throws IOException {
/* 115 */       f.check(RMAPS.this);
/* 116 */       boolean isSame = true;
/* 117 */       this.am = f.i();
/* 118 */       if (this.am != RMAPS.this.all().size()) {
/* 119 */         isSame = false;
/*     */       }
/* 121 */       this.order = Alloc.ii(Math.max(RMAPS.this.all().size(), this.am));
/* 122 */       Arrays.fill(this.order, -1);
/*     */ 
/*     */       
/* 125 */       for (int i = 0; i < this.am; i++) {
/* 126 */         String k = f.chars();
/* 127 */         if (RMAPS.this.map.get(k) != null) {
/* 128 */           this.order[i] = ((MAPPED)RMAPS.this.map.get(k)).index();
/* 129 */           int j = isSame & ((i == ((MAPPED)RMAPS.this.map.get(k)).index()) ? 1 : 0);
/*     */         } else {
/* 131 */           isSame = false;
/*     */         } 
/*     */       } 
/*     */       
/* 135 */       this.isSame = isSame;
/* 136 */       f.check(RMAPS.this);
/*     */     }
/*     */     
/*     */     public T loadB(FileGetter f, T pref) throws IOException {
/* 140 */       int i = f.i();
/* 141 */       if (i < 0)
/* 142 */         return null; 
/* 143 */       if (this.isSame)
/* 144 */         return (T)RMAPS.this.all().get(i); 
/* 145 */       if (this.order[i] == -1) {
/* 146 */         return (pref == null) ? (T)RMAPS.this.all().get(0) : pref;
/*     */       }
/* 148 */       return (T)RMAPS.this.all().get(this.order[i]);
/*     */     }
/*     */     
/*     */     public int loadI(FileGetter f) throws IOException {
/* 152 */       int i = f.i();
/* 153 */       if (i < 0)
/* 154 */         return -1; 
/* 155 */       if (this.isSame)
/* 156 */         return ((MAPPED)RMAPS.this.all().get(i)).index(); 
/* 157 */       if (this.order[i] == -1) {
/* 158 */         return -1;
/*     */       }
/* 160 */       return ((MAPPED)RMAPS.this.all().get(this.order[i])).index();
/*     */     }
/*     */     
/*     */     public T get(int index) {
/* 164 */       if (index < 0)
/* 165 */         return null; 
/* 166 */       if (this.isSame)
/* 167 */         return (T)RMAPS.this.all().get(index); 
/* 168 */       if (this.order[index] == -1) {
/* 169 */         return null;
/*     */       }
/* 171 */       return (T)RMAPS.this.all().get(this.order[index]);
/*     */     }
/*     */     
/*     */     public T load(FileGetter f) throws IOException {
/* 175 */       int i = f.i();
/* 176 */       if (i < 0)
/* 177 */         return null; 
/* 178 */       if (this.isSame)
/* 179 */         return (T)RMAPS.this.all().get(i); 
/* 180 */       if (this.order[i] == -1) {
/* 181 */         return null;
/*     */       }
/* 183 */       return (T)RMAPS.this.all().get(this.order[i]);
/*     */     }
/*     */     
/*     */     public byte[] fix(byte[] old, byte defValue) {
/* 187 */       if (this.isSame) {
/* 188 */         return old;
/*     */       }
/* 190 */       if (old.length != this.am) {
/* 191 */         throw new RuntimeException();
/*     */       }
/* 193 */       byte[] amounts = Alloc.bb(RMAPS.this.all().size());
/*     */       
/* 195 */       Arrays.fill(amounts, defValue);
/* 196 */       for (int i = 0; i < old.length; i++) {
/* 197 */         int o = this.order[i];
/* 198 */         if (o != -1) {
/* 199 */           amounts[o] = old[i];
/*     */         }
/*     */       } 
/* 202 */       return old;
/*     */     }
/*     */ 
/*     */     
/*     */     public int fix(int old, int fallback) {
/* 207 */       if (this.isSame) {
/* 208 */         return old;
/*     */       }
/*     */       
/* 211 */       if (old < 0 || old >= this.order.length)
/* 212 */         return fallback; 
/* 213 */       int o = this.order[old];
/* 214 */       if (o != -1)
/* 215 */         return o; 
/* 216 */       return fallback;
/*     */     }
/*     */     
/*     */     public int[] fix(int[] old, int defValue) {
/* 220 */       if (this.isSame) {
/* 221 */         return old;
/*     */       }
/*     */       
/* 224 */       int[] nn = Alloc.ii(RMAPS.this.all().size());
/* 225 */       Arrays.fill(nn, defValue);
/* 226 */       for (int i = 0; i < this.am; i++) {
/* 227 */         int o = this.order[i];
/* 228 */         if (o != -1) {
/* 229 */           nn[o] = old[i];
/*     */         }
/*     */       } 
/* 232 */       return nn;
/*     */     }
/*     */     
/*     */     public boolean isSame() {
/* 236 */       return this.isSame;
/*     */     }
/*     */     
/*     */     public void load(int[] amounts, FileGetter f, int defValue) throws IOException {
/* 240 */       RMAPS.this.check(amounts.length);
/* 241 */       if (this.isSame) {
/* 242 */         f.is(amounts);
/*     */         return;
/*     */       } 
/* 245 */       int[] old = Alloc.ii(this.am);
/* 246 */       f.is(old);
/* 247 */       Arrays.fill(amounts, defValue);
/* 248 */       for (int i = 0; i < this.am; i++) {
/* 249 */         int o = this.order[i];
/* 250 */         if (o != -1) {
/* 251 */           amounts[o] = old[i];
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(long[] amounts, FileGetter f, long defValue) throws IOException {
/* 258 */       RMAPS.this.check(amounts.length);
/* 259 */       if (this.isSame) {
/* 260 */         f.ls(amounts);
/*     */         return;
/*     */       } 
/* 263 */       long[] old = new long[this.am];
/* 264 */       f.ls(old);
/* 265 */       Arrays.fill(amounts, defValue);
/* 266 */       for (int i = 0; i < this.am; i++) {
/* 267 */         int o = this.order[i];
/* 268 */         if (o != -1) {
/* 269 */           amounts[o] = old[i];
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(short[] amounts, FileGetter f, short defValue) throws IOException {
/* 276 */       RMAPS.this.check(amounts.length);
/* 277 */       if (this.isSame) {
/* 278 */         f.ss(amounts);
/*     */         return;
/*     */       } 
/* 281 */       short[] old = new short[this.am];
/* 282 */       f.ss(old);
/* 283 */       Arrays.fill(amounts, defValue);
/* 284 */       for (int i = 0; i < this.am; i++) {
/* 285 */         int o = this.order[i];
/* 286 */         if (o != -1) {
/* 287 */           amounts[o] = old[i];
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(double[] amounts, FileGetter f, double defValue) throws IOException {
/* 294 */       RMAPS.this.check(amounts.length);
/*     */       
/* 296 */       if (this.isSame) {
/* 297 */         f.ds(amounts);
/*     */         
/*     */         return;
/*     */       } 
/* 301 */       double[] old = new double[this.am];
/* 302 */       f.ds(old);
/* 303 */       Arrays.fill(amounts, defValue);
/* 304 */       for (int i = 0; i < this.am; i++) {
/* 305 */         int o = this.order[i];
/* 306 */         if (o != -1) {
/* 307 */           amounts[o] = old[i];
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     public void load(SAVABLE[] amounts, FileGetter f) throws IOException {
/* 313 */       RMAPS.this.check(amounts.length);
/* 314 */       if (this.isSame) {
/* 315 */         byte b; int i; SAVABLE[] arrayOfSAVABLE; for (i = (arrayOfSAVABLE = amounts).length, b = 0; b < i; ) { SAVABLE s = arrayOfSAVABLE[b];
/* 316 */           s.load(f); b++; }
/*     */         
/*     */         return;
/*     */       } 
/* 320 */       load((LIST<? extends SAVABLE>)new ArrayList((Object[])amounts), f);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(LIST<? extends SAVABLE> amounts, FileGetter f) throws IOException {
/* 325 */       RMAPS.this.check(amounts.size());
/* 326 */       if (this.isSame) {
/* 327 */         for (SAVABLE s : amounts) {
/* 328 */           s.load(f);
/*     */         }
/*     */         return;
/*     */       } 
/* 332 */       for (SAVABLE s : amounts) {
/* 333 */         s.clear();
/*     */       }
/*     */       
/* 336 */       int matches = 0; int i;
/* 337 */       for (i = 0; i < this.am; i++) {
/* 338 */         int o = this.order[i];
/* 339 */         if (o != -1) {
/* 340 */           matches++;
/*     */         }
/*     */       } 
/* 343 */       for (i = matches; i < this.am; i++) {
/* 344 */         ((SAVABLE)amounts.get(0)).load(f);
/*     */       }
/* 346 */       ((SAVABLE)amounts.get(0)).clear();
/* 347 */       for (i = 0; i < this.am; i++) {
/* 348 */         int o = this.order[i];
/* 349 */         if (o != -1)
/* 350 */           ((SAVABLE)amounts.get(o)).load(f); 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMAPS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */