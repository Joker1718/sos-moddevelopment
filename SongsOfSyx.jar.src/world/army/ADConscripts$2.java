/*     */ package world.army;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements INT_O<Faction>
/*     */ {
/*     */   public int get(Faction t) {
/*  90 */     return ((INT_O.INT_OE)ADConscripts.this.total.get(r.index)).get(t) - ((INT_O.INT_OE)ADConscripts.this.used.get(r.index)).get(t);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(Faction t) {
/*  95 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(Faction t) {
/* 100 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADConscripts$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */