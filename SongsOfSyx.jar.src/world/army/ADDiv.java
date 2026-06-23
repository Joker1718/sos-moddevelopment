/*     */ package world.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.DivisionBanners;
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ public abstract class ADDiv
/*     */   implements WDIV
/*     */ {
/*  16 */   short armyI = -1;
/*     */   public final int index;
/*     */   
/*     */   protected ADDiv(int index) {
/*  20 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected abstract int type();
/*     */   
/*     */   protected void save(FilePutter file) {
/*  26 */     file.s(this.armyI);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  30 */     this.armyI = file.s();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void armySet(WArmy e) {
/*  38 */     report(-1);
/*     */     
/*  40 */     WArmy old = army();
/*  41 */     if (old != null) {
/*  42 */       old.divs().remove(this);
/*     */     }
/*     */     
/*  45 */     this.armyI = (e == null) ? -1 : e.armyIndex();
/*  46 */     if (e != null) {
/*  47 */       army().divs().add(this);
/*     */     }
/*  49 */     report(1);
/*  50 */     armyChange(old, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void disband() {
/*  56 */     reassign((WArmy)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void armyChange(WArmy old, WArmy newW) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final WArmy army() {
/*  66 */     if (this.armyI == -1)
/*  67 */       return null; 
/*  68 */     return (WORLD.ENTITIES()).armies.get(this.armyI);
/*     */   }
/*     */   
/*     */   protected void report(int i) {
/*  72 */     AD.register(this, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reassign(WArmy a) {
/*  77 */     if (needSupplies() && army() != null) {
/*  78 */       WArmy oldA = army();
/*  79 */       double sup = ((ADSupply)(AD.supplies()).all.get(0)).current().get(army());
/*  80 */       if (sup > 0.0D) {
/*  81 */         sup = menTarget() / sup;
/*     */       }
/*  83 */       armySet(a);
/*  84 */       AD.supplies().transfer(this, oldA, army());
/*     */     } else {
/*     */       
/*  87 */       armySet(a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final DivisionBanners.DivisionBanner banner() {
/*  93 */     return (GAME.ARMIES()).banners.get(bannerI());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Faction faction() {
/*  99 */     if (army() == null)
/* 100 */       return null; 
/* 101 */     return army().faction();
/*     */   }
/*     */   
/*     */   public abstract void menSet(int paramInt);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */