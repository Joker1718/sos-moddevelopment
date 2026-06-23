/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.race.appearence.RType;
/*     */ import init.type.HTYPE;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.text.Str;
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
/*     */ public class NamePart
/*     */ {
/*     */   private final Bits bData;
/*     */   private final Bit bC;
/* 276 */   private final ArrayList<Str> allNames = new ArrayList(4096);
/* 277 */   private int kk = 1;
/* 278 */   private final Str ss = new Str(1024);
/*     */   private boolean first;
/*     */   
/*     */   NamePart(boolean first) {
/* 282 */     int scroll = first ? 0 : 1;
/* 283 */     this.bData = new Bits(4095 << 16 * scroll);
/* 284 */     this.bC = new Bit(4096 << 16 * scroll);
/* 285 */     this.allNames.add(new Str(1));
/* 286 */     this.first = first;
/*     */   }
/*     */   
/*     */   public CharSequence name(Race r, HTYPE t, int gender, int nameData) {
/* 290 */     if (this.bC.is(nameData)) {
/* 291 */       return (CharSequence)this.allNames.get(this.bData.get(nameData));
/*     */     }
/* 293 */     this.ss.clear();
/* 294 */     if (this.first) {
/* 295 */       this.ss.add((CharSequence)((RType)(r.appearance()).types.getC(gender)).names.firstNames.getC(this.bData.get(nameData)));
/*     */     } else {
/* 297 */       this.ss.add((CharSequence)((RType)(r.appearance()).types.getC(gender)).names.lastNames.getC(this.bData.get(nameData)));
/*     */     } 
/* 299 */     return (CharSequence)this.ss;
/*     */   }
/*     */   
/*     */   public CharSequence name(Induvidual i) {
/* 303 */     return name(i.race(), i.hType(), StatsAppearance.this.gender.get(i), StatsAppearance.this.nameData.get(i));
/*     */   }
/*     */   
/*     */   public void randmoize(Induvidual i) {
/* 307 */     int g = StatsAppearance.this.gender.get(i);
/* 308 */     int max = 0;
/* 309 */     if (this.first) {
/* 310 */       max = ((RType)(i.race().appearance()).types.getC(g)).names.firstNames.size();
/*     */     } else {
/* 312 */       max = ((RType)(i.race().appearance()).types.getC(g)).names.lastNames.size();
/*     */     } 
/* 314 */     int data = StatsAppearance.this.nameData.get(i);
/* 315 */     data = this.bC.set(data, false);
/* 316 */     data = this.bData.set(data, RND.rInt(max));
/* 317 */     StatsAppearance.this.nameData.set(i, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void copy(Induvidual i, int nameDataToCopy) {
/* 322 */     if (this.bC.is(nameDataToCopy)) {
/* 323 */       CharSequence nn = (CharSequence)this.allNames.get(this.bData.get(nameDataToCopy));
/* 324 */       setCustom(i, nn);
/*     */     } else {
/* 326 */       int data = this.bData.set(StatsAppearance.this.nameData.get(i), this.bData.get(nameDataToCopy));
/* 327 */       StatsAppearance.this.nameData.set(i, data);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCustom(Induvidual i, CharSequence cc) {
/* 332 */     if (cc.length() == 0) {
/* 333 */       int j = StatsAppearance.this.nameData.get(i);
/* 334 */       j = this.bData.set(j, 0);
/* 335 */       j = this.bC.set(j, true);
/* 336 */       StatsAppearance.this.nameData.set(i, j);
/*     */       
/*     */       return;
/*     */     } 
/* 340 */     if (this.kk >= this.allNames.max())
/* 341 */       this.kk = 1; 
/* 342 */     while (this.kk >= this.allNames.size()) {
/* 343 */       this.allNames.add(new Str(32));
/*     */     }
/* 345 */     ((Str)this.allNames.get(this.kk)).clear().add(cc);
/*     */     
/* 347 */     int data = StatsAppearance.this.nameData.get(i);
/* 348 */     data = this.bData.set(data, this.kk);
/* 349 */     data = this.bC.set(data, true);
/* 350 */     StatsAppearance.this.nameData.set(i, data);
/* 351 */     this.kk++;
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 355 */     file.i(this.kk);
/* 356 */     file.i(this.allNames.size());
/* 357 */     for (int i = 0; i < this.allNames.size(); i++) {
/* 358 */       ((Str)this.allNames.get(i)).save(file);
/*     */     }
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 363 */     this.kk = file.i();
/* 364 */     if (this.kk == 0)
/* 365 */       this.kk = 1; 
/* 366 */     int am = file.i();
/* 367 */     this.allNames.clearSloppy();
/* 368 */     for (int i = 0; i < am; i++) {
/* 369 */       this.allNames.add(new Str(32));
/* 370 */       ((Str)this.allNames.get(this.allNames.size() - 1)).load(file);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/* 376 */     this.kk = 1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAppearance$NamePart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */