/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements RD.RDUpdatable
/*     */ {
/*  75 */   private final double dt = 2.0D / TIME.secondsPerDay();
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Region reg, double time) {
/*  80 */     int t = RDMilitary.this.garrisonTarget(reg);
/*     */     
/*  82 */     if (WORLD.BATTLES().besigedTime(reg) > 0.0D) {
/*     */       
/*  84 */       int i = (int)(RDMilitary.this.garrisonTarget(reg) * (1.0D - RDMilitary.this.besigeMul(reg)));
/*  85 */       i = (int)Math.min(RDMilitary.this.garrison.get(reg) * (1.0D - RDMilitary.this.besigeMul(reg)), i);
/*  86 */       i = CLAMP.i(i, 0, t);
/*  87 */       if (i < RDMilitary.this.garrison.get(reg)) {
/*  88 */         RDMilitary.this.garrison.set(reg, i);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  94 */     int d = RDMilitary.this.garrisonTarget(reg);
/*     */ 
/*     */ 
/*     */     
/*  98 */     RDMilitary.this.garrison.moveTo(reg, time * this.dt * 50.0D, d);
/*  99 */     double f = RDMilitary.this.bFortification.get((BOOSTABLE_O)reg) - RDMilitary.this.fort.getD(reg);
/* 100 */     double nn = RDMilitary.this.fort.getD(reg) + time * this.dt * f;
/* 101 */     if (f < 0.0D) {
/* 102 */       nn += 3.0D * time * this.dt * f;
/* 103 */       nn = Math.max(nn, 0.0D);
/*     */     } else {
/* 105 */       nn = Math.min(nn, RDMilitary.this.bFortification.get((BOOSTABLE_O)reg));
/* 106 */     }  RDMilitary.this.fort.setD(reg, nn);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Region reg) {
/* 114 */     RDMilitary.this.garrison.set(reg, RDMilitary.this.garrisonTarget(reg));
/* 115 */     RDMilitary.this.fort.setD(reg, RDMilitary.this.bFortification.get((BOOSTABLE_O)reg));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDMilitary$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */