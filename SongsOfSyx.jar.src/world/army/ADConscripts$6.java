/*     */ package world.army;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.INT_O;
/*     */ import world.entity.army.WArmy;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ADInit.Updater
/*     */ {
/*     */   public void update(Faction f, double timeSinceLast) {
/* 145 */     if (f == null || !f.isActive()) {
/*     */       return;
/*     */     }
/* 148 */     for (Race r : RACES.all()) {
/* 149 */       int n = ADConscripts.this.total(r).get(f);
/* 150 */       int t = RD.MILITARY().conscripts(r, f);
/* 151 */       if (t < n) {
/* 152 */         ((INT_O.INT_OE)(AD.conscripts()).total.get(r.index())).set(f, t);
/*     */         continue;
/*     */       } 
/* 155 */       double d = (t - n);
/*     */       
/* 157 */       if (d > 0.0D) {
/*     */         
/* 159 */         d *= TIME.secondsPerDayI() * timeSinceLast / 8.0D;
/* 160 */         n += (int)d;
/* 161 */         if (RND.rFloat() < d - (int)d)
/* 162 */           n++; 
/* 163 */       } else if (d < 0.0D) {
/* 164 */         n = t;
/*     */       } 
/*     */       
/* 167 */       n = CLAMP.i(n, 0, t);
/*     */       
/* 169 */       ((INT_O.INT_OE)(AD.conscripts()).total.get(r.index())).set(f, n);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update(WArmy a, double timeSinceLast) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADConscripts$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */