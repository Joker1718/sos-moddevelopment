/*     */ package settlement.stats.muls;
/*     */ 
/*     */ import game.boosting.BoostSpecs;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class StatMultiplier
/*     */   extends INFO
/*     */   implements MAPPED
/*     */ {
/*     */   private final int index;
/*     */   public final String key;
/*     */   public final CharSequence verb;
/* 186 */   protected boolean[] classes = new boolean[HCLASSES.ALL().size()];
/*     */   public final BoostSpecs boosters;
/*     */   
/*     */   private StatMultiplier(StatsMultipliers.C cc, LISTE<StatMultiplier> all, HCLASS... cl) {
/* 190 */     super(cc.name, cc.desc);
/* 191 */     this.verb = cc.verb;
/* 192 */     this.index = all.add(this);
/* 193 */     this.key = cc.key;
/*     */     
/* 195 */     this.boosters = new BoostSpecs(cc.name, (SPRITE)(UI.icons()).s.crown, true); byte b; int i;
/*     */     HCLASS[] arrayOfHCLASS;
/* 197 */     for (i = (arrayOfHCLASS = cl).length, b = 0; b < i; ) { HCLASS c = arrayOfHCLASS[b];
/* 198 */       this.classes[c.index()] = true;
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public int index() {
/* 204 */     return this.index;
/*     */   }
/*     */   
/*     */   public boolean available(HCLASS cl) {
/* 208 */     return this.classes[cl.index()];
/*     */   }
/*     */   
/*     */   public boolean available(HTYPE t) {
/* 212 */     return this.classes[t.CLASS.index()];
/*     */   }
/*     */   
/*     */   public boolean available(Induvidual i) {
/* 216 */     return available(i.clas());
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract double value(Induvidual paramInduvidual);
/*     */   
/*     */   public abstract double value(HCLASS paramHCLASS, Race paramRace, int paramInt);
/*     */   
/*     */   protected abstract void update(double paramDouble);
/*     */   
/*     */   public String key() {
/* 227 */     return this.key;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\muls\StatsMultipliers$StatMultiplier.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */