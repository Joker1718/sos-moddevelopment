/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ class null
/*     */   implements RD.RDUpdatable
/*     */ {
/*  69 */   final double dt = 1.0D / (TIME.secondsPerDay() * 16);
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Region reg, double time) {
/*  74 */     double min = RDReligions.this.min(reg);
/*  75 */     double tot = RDReligions.this.tot(reg) - min;
/*     */     
/*  77 */     for (RDReligions.RDReligion r : RDReligions.this.all) {
/*  78 */       double target = Math.round(255.0D * (r.boost.get((BOOSTABLE_O)reg) - min) / tot);
/*  79 */       double now = target + this.dt * (target - r.current.get(reg));
/*  80 */       now = CLAMP.d(now, Math.min(target, r.current.get(reg)), Math.max(target, r.current.get(reg)));
/*  81 */       r.current.set(reg, (int)now);
/*     */     } 
/*     */     
/*  84 */     setop(reg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Region reg) {
/*  90 */     double min = RDReligions.this.min(reg);
/*  91 */     double tot = RDReligions.this.tot(reg) - min;
/*  92 */     for (RDReligions.RDReligion r : RDReligions.this.all) {
/*  93 */       double target = Math.round(255.0D * (r.boost.get((BOOSTABLE_O)reg) - min) / tot);
/*  94 */       r.current.set(reg, (int)target);
/*     */     } 
/*  96 */     setop(reg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setop(Region reg) {
/* 102 */     double op = 0.0D;
/*     */     
/* 104 */     for (int ri = 0; ri < RDReligions.this.all.size(); ri++) {
/* 105 */       double vv = 0.0D;
/* 106 */       RDReligions.RDReligion r = (RDReligions.RDReligion)RDReligions.this.all.get(ri);
/* 107 */       for (int ri2 = 0; ri2 < RDReligions.this.all.size(); ri2++) {
/* 108 */         RDReligions.RDReligion r2 = (RDReligions.RDReligion)RDReligions.this.all.get(ri2);
/* 109 */         double am = r2.current.getD(reg);
/* 110 */         am *= r.religion.opposition(r2.religion);
/* 111 */         vv += am;
/*     */       } 
/* 113 */       op += vv * r.current.getD(reg);
/*     */     } 
/*     */     
/* 116 */     op = CLAMP.d(op, 0.0D, 1.0D);
/* 117 */     RDReligions.this.opposition.setD(reg, op);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDReligions$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */