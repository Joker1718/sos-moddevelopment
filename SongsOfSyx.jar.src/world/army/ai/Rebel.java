/*     */ package world.army.ai;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.time.TIME;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.updating.IUpdater;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Rebel
/*     */   extends IUpdater {
/*     */   public Rebel() {
/*  20 */     super(1, (TIME.secondsPerDay() / 2));
/*     */   }
/*     */   private static WArmy aa;
/*     */   
/*     */   protected void update(int i, double timeSinceLast) {
/*  25 */     updateRebel(aa);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void updateRebel(WArmy a) {
/*  31 */     if (AD.men(null).get(a) == 0) {
/*  32 */       a.disband();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  37 */     Region hh = a.region();
/*  38 */     aa = a;
/*  39 */     if (hh == null) {
/*  40 */       WRegFinder.RegDist rr = (WORLD.PATH()).regFinder.single(a.ctx(), a.cty(), WRegFinder.Treaty.REG_NEIGHS, ally.get(a));
/*  41 */       if (rr != null) {
/*  42 */         a.setDestination(rr.reg.cx(), rr.reg.cy());
/*     */       } else {
/*  44 */         for (WRegFinder.RegDist r : (WORLD.PATH()).regFinder.all(a.ctx(), a.cty(), WRegFinder.Treaty.REG_NEIGHS, rebelTarget.get(a))) {
/*  45 */           if (r != null && AD.power().get(a) > (RD.MILITARY()).power.getD(r.reg)) {
/*  46 */             a.raid(r.reg);
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */         
/*  52 */         a.disband();
/*     */       } 
/*  54 */     } else if (hh.faction() == FACTIONS.player()) {
/*  55 */       if ((RD.DEVASTATION()).current.getD(hh) < 0.9D) {
/*  56 */         a.raid(true);
/*     */         
/*     */         return;
/*     */       } 
/*  60 */       if (AD.power().get(a) > (RD.MILITARY()).power.getD(hh)) {
/*  61 */         a.besiege(hh);
/*  62 */       } else if (RND.oneIn(16)) {
/*  63 */         a.disband();
/*     */       } 
/*     */     } else {
/*  66 */       for (WRegFinder.RegDist r : (WORLD.PATH()).regFinder.all(a.ctx(), a.cty(), WRegFinder.Treaty.REG_NEIGHS, rebelTarget.get(a))) {
/*  67 */         if (r != null && AD.power().get(a) > (RD.MILITARY()).power.getD(r.reg)) {
/*  68 */           a.raid(r.reg);
/*     */           return;
/*     */         } 
/*  71 */         a.disband();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   private static final Sel ally = new Sel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  85 */         return (t.faction() == null);
/*     */       }
/*     */     };
/*     */   
/*  89 */   private static final Sel rebelTarget = new Sel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  93 */         return (t.faction() == FACTIONS.player() && AD.power().get(Rebel.aa) > power(t));
/*     */       }
/*     */       
/*     */       private double power(Region reg) {
/*  97 */         double m = 0.0D;
/*  98 */         for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/*  99 */           if (a.faction() != null && (a.faction() == FACTIONS.player() || (DIP.get(a.faction(), (Faction)FACTIONS.player())).ally))
/* 100 */             m += AD.power().get(a); 
/*     */         } 
/* 102 */         return m + (RD.MILITARY()).power.getD(reg);
/*     */       }
/*     */     };
/*     */   
/*     */   static abstract class Sel extends WRegSel {
/*     */     WArmy army;
/*     */     
/*     */     public WRegSel get(WArmy army) {
/* 110 */       this.army = army;
/* 111 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Rebel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */