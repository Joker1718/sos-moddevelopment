/*     */ package game.battle.thread.trajectory;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ final class Request
/*     */   implements SAVABLE
/*     */ {
/*  18 */   private short ammo = -1;
/*  19 */   private final float[] refs = new float[(Config.battle()).MEN_PER_DIVISION];
/*  20 */   private final int[] pixels = Alloc.ii((Config.battle()).MEN_PER_DIVISION * 2);
/*  21 */   private final byte[] counts = Alloc.bb((Config.battle()).MEN_PER_DIVISION);
/*     */   public Request() {
/*  23 */     Arrays.fill(this.refs, Float.NaN);
/*  24 */     Arrays.fill(this.pixels, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean request(int pos, Humanoid h, Div div) {
/*  29 */     EquipRange a = div.settings().ammo();
/*  30 */     if (a == null) {
/*  31 */       this.ammo = -1;
/*  32 */       return false;
/*     */     } 
/*     */     
/*  35 */     this.counts[pos] = 0;
/*     */     
/*  37 */     if (a.tIndex != this.ammo) {
/*  38 */       this.ammo = a.tIndex;
/*  39 */       set(pos, (float)a.ref(h.indu()), h);
/*  40 */       return false;
/*     */     } 
/*     */     
/*  43 */     int pi = pos * 2;
/*  44 */     if (this.pixels[pi] != h.body().cX() || this.pixels[pi + 1] != h.body().cY()) {
/*  45 */       set(pos, (float)a.ref(h.indu()), h);
/*  46 */       return false;
/*     */     } 
/*     */     
/*  49 */     float ref = (float)a.ref(h.indu());
/*     */     
/*  51 */     if (ref != this.refs[pos]) {
/*  52 */       set(pos, (float)a.ref(h.indu()), h);
/*  53 */       return false;
/*     */     } 
/*     */     
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(int pos, float ref, Humanoid h) {
/*  61 */     this.refs[pos] = ref;
/*  62 */     int pi = pos * 2;
/*  63 */     this.pixels[pi] = h.body().cX();
/*  64 */     this.pixels[pi + 1] = h.body().cY();
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  69 */     file.s(this.ammo);
/*  70 */     file.fs(this.refs);
/*  71 */     file.is(this.pixels);
/*  72 */     file.bs(this.counts);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  77 */     this.ammo = file.s();
/*  78 */     file.fs(this.refs);
/*  79 */     file.is(this.pixels);
/*  80 */     file.bs(this.counts);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  85 */     this.ammo = -1;
/*  86 */     Arrays.fill(this.refs, 0.0F);
/*  87 */     Arrays.fill(this.pixels, 0);
/*  88 */     Arrays.fill(this.counts, (byte)121);
/*     */   }
/*     */   
/*     */   public float ref(int i) {
/*  92 */     return this.refs[i];
/*     */   }
/*     */   
/*     */   public int x(int i) {
/*  96 */     return this.pixels[i * 2];
/*     */   }
/*     */   
/*     */   public int y(int i) {
/* 100 */     return this.pixels[i * 2 + 1];
/*     */   }
/*     */   
/*     */   public EquipRange ammo() {
/* 104 */     if (this.ammo == -1)
/* 105 */       return null; 
/* 106 */     return (EquipRange)STATS.EQUIP().RANGED().get(this.ammo);
/*     */   }
/*     */   
/*     */   public boolean count(int i) {
/* 110 */     if (this.counts[i] > 120)
/* 111 */       return false; 
/* 112 */     this.counts[i] = (byte)(this.counts[i] + 1);
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\trajectory\Request.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */