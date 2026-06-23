/*     */ package game.boosting.tmp;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ final class Data
/*     */   implements SAVABLE
/*     */ {
/*     */   private final Bitmap1D specActive;
/*     */   private final float[] add;
/*     */   private final float[] mul;
/*     */   
/*     */   Data(int specs) {
/*  22 */     this.specActive = new Bitmap1D(specs + 2, false);
/*  23 */     this.add = new float[BOOSTING.ALL().size()];
/*  24 */     this.mul = new float[BOOSTING.ALL().size()];
/*  25 */     Arrays.fill(this.mul, 1.0F);
/*     */   }
/*     */   
/*     */   private void cache() {
/*  29 */     if (this.specActive.get(this.specActive.size() - 2)) {
/*     */       
/*  31 */       Arrays.fill(this.add, 0.0F);
/*  32 */       Arrays.fill(this.mul, 1.0F);
/*  33 */       boolean any = false;
/*  34 */       for (TmpBoostSpec s : GAME.BOOST().specs()) {
/*  35 */         if (this.specActive.get(s.index)) {
/*  36 */           any = true;
/*  37 */           for (BoostSpec ss : s.spec.all()) {
/*  38 */             if (ss.booster.isMul) {
/*  39 */               this.mul[ss.boostable.index()] = (float)(this.mul[ss.boostable.index()] * ss.booster.to()); continue;
/*     */             } 
/*  41 */             this.add[ss.boostable.index()] = (float)(this.add[ss.boostable.index()] + ss.booster.to());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  47 */       this.specActive.set(this.specActive.size() - 1, any);
/*  48 */       this.specActive.set(this.specActive.size() - 2, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public double add(Boostable bo) {
/*  53 */     cache();
/*  54 */     return this.add[bo.index()];
/*     */   }
/*     */   
/*     */   public double mul(Boostable bo) {
/*  58 */     cache();
/*  59 */     return this.mul[bo.index()];
/*     */   }
/*     */   
/*     */   public void set(TmpBoostSpec s, boolean set) {
/*  63 */     if (set == this.specActive.get(s.index))
/*     */       return; 
/*  65 */     this.specActive.set(s.index, set);
/*  66 */     setDirty();
/*     */   }
/*     */   
/*     */   public void setDirty() {
/*  70 */     this.specActive.set(this.specActive.size() - 2, true);
/*     */   }
/*     */   
/*     */   public boolean is(TmpBoostSpec spec) {
/*  74 */     cache();
/*  75 */     return this.specActive.get(spec.index);
/*     */   }
/*     */   
/*     */   public boolean hasAny() {
/*  79 */     cache();
/*  80 */     return this.specActive.get(this.specActive.size() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  85 */     this.specActive.clear();
/*  86 */     setDirty();
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  91 */     this.specActive.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  96 */     this.specActive.load(file);
/*  97 */     setDirty();
/*     */   }
/*     */   
/*     */   public void load(FileGetter file, int[] oldOrder) throws IOException {
/* 101 */     this.specActive.clear();
/* 102 */     Bitmap1D old = new Bitmap1D(this.specActive.size(), false);
/* 103 */     old.load(file);
/*     */     
/* 105 */     for (int i = 0; i < old.size(); i++) {
/* 106 */       if (old.get(i) && i < oldOrder.length && oldOrder[i] != -1) {
/* 107 */         this.specActive.set(oldOrder[i], true);
/*     */       }
/*     */     } 
/* 110 */     setDirty();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */