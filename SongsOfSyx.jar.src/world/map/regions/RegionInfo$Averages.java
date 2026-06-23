/*     */ package world.map.regions;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import snake2d.LOG;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Averages
/*     */ {
/* 239 */   public final RegionInfo.RegValue[] terrains = new RegionInfo.RegValue[TERRAINS.ALL().size()];
/*     */   public final RegionInfo.RegValue fertility;
/*     */   public final RegionInfo.RegValue area;
/*     */   private static boolean log = false;
/*     */   
/*     */   Averages() {
/* 245 */     RegionInfo.ave = this;
/* 246 */     if (log) {
/* 247 */       GAME.Notify("here");
/*     */     }
/* 249 */     this.fertility = new RegionInfo.RegValue()
/*     */       {
/*     */         public double rawAI(Region reg)
/*     */         {
/* 253 */           double f = 0.1D + reg.info.moisture();
/* 254 */           double a = reg.info.area;
/* 255 */           return f * f * a;
/*     */         }
/*     */ 
/*     */         
/*     */         public double raw(Region reg) {
/* 260 */           return reg.info.moisture();
/*     */         }
/*     */       };
/*     */     
/* 264 */     log(this.fertility, "fertility");
/*     */ 
/*     */ 
/*     */     
/* 268 */     this.area = new RegionInfo.RegValue()
/*     */       {
/*     */         public double rawAI(Region reg)
/*     */         {
/* 272 */           double f = 0.1D + reg.info.moisture();
/* 273 */           double a = reg.info.area;
/* 274 */           return f * a * a;
/*     */         }
/*     */ 
/*     */         
/*     */         public double raw(Region reg) {
/* 279 */           return reg.info.area;
/*     */         }
/*     */       };
/*     */     
/* 283 */     log(this.area, "area");
/*     */ 
/*     */     
/* 286 */     for (int i = 0; i < TERRAINS.ALL().size(); i++) {
/* 287 */       final TERRAIN t = (TERRAIN)TERRAINS.ALL().get(i);
/* 288 */       this.terrains[i] = new RegionInfo.RegValue()
/*     */         {
/*     */           public double rawAI(Region reg)
/*     */           {
/* 292 */             double f = 0.25D + reg.info.moisture();
/* 293 */             return (0.5D + reg.info.terrain(t)) * reg.info.area * f;
/*     */           }
/*     */ 
/*     */           
/*     */           public double raw(Region reg) {
/* 298 */             return reg.info.terrain(t);
/*     */           }
/*     */         };
/*     */       
/* 302 */       log(this.terrains[i], "t " + t.key);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void log(RegionInfo.RegValue trans, String name) {
/* 307 */     if (!log)
/*     */       return; 
/* 309 */     LOG.ln(name);
/* 310 */     double ave = 0.0D;
/* 311 */     double ma = 0.0D;
/* 312 */     double mi = 1.0D;
/* 313 */     double mv = 0.0D;
/* 314 */     double miv = Double.MAX_VALUE;
/*     */     int ri;
/* 316 */     for (ri = 0; ri < WORLD.REGIONS().active().size(); ri++) {
/* 317 */       Region reg = (Region)WORLD.REGIONS().active().get(ri);
/* 318 */       double d = trans.getAi(reg);
/* 319 */       ave += d;
/* 320 */       ma = Math.max(d, ma);
/* 321 */       mi = Math.min(d, mi);
/* 322 */       mv = Math.max(mv, trans.rawAI(reg));
/* 323 */       miv = Math.min(miv, trans.rawAI(reg));
/*     */     } 
/* 325 */     ave /= WORLD.REGIONS().active().size();
/* 326 */     LOG.ln("AVE: " + (int)(100.0D * ave));
/* 327 */     LOG.ln("MIN: " + (int)(100.0D * mi));
/* 328 */     LOG.ln("MAX: " + (int)(100.0D * ma));
/* 329 */     LOG.ln("VVV: " + trans.getAi(miv) + " -> " + trans.getAi(mv));
/*     */     
/* 331 */     ave = 0.0D;
/* 332 */     ma = 0.0D;
/* 333 */     mi = 1.0D;
/* 334 */     mv = 0.0D;
/* 335 */     for (ri = 0; ri < WORLD.REGIONS().active().size(); ri++) {
/* 336 */       Region reg = (Region)WORLD.REGIONS().active().get(ri);
/* 337 */       double d = trans.get(reg);
/* 338 */       ave += d;
/* 339 */       ma = Math.max(d, ma);
/* 340 */       mi = Math.min(d, mi);
/* 341 */       mv = Math.max(mv, trans.raw(reg));
/*     */     } 
/* 343 */     ave /= WORLD.REGIONS().active().size();
/*     */     
/* 345 */     LOG.ln("AVE: " + (int)(100.0D * ave));
/* 346 */     LOG.ln("MIN: " + (int)(100.0D * mi));
/* 347 */     LOG.ln("MAX: " + (int)(100.0D * ma));
/* 348 */     LOG.ln("VVV: " + trans.get(mi) + " -> " + trans.get(ma));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\RegionInfo$Averages.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */