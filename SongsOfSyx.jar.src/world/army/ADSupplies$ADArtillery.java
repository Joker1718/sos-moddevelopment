/*     */ package world.army;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import world.entity.army.WArmy;
/*     */ import world.entity.army.WArmyState;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ADArtillery
/*     */   implements INDEXED
/*     */ {
/*     */   public final ROOM_ARTILLERY art;
/*     */   public final INT_O.INT_OE<WArmy> target;
/* 258 */   private final ArrayListGrower<ADSupply> supplies = new ArrayListGrower();
/*     */   
/*     */   ADArtillery(ADInit init, ROOM_ARTILLERY art, LISTE<ADSupply> sups) {
/* 261 */     this.art = art;
/* 262 */     this.target = (INT_O.INT_OE<WArmy>)new DataO<WArmy>.DataByte(init.dataA, "ART_TARGET_" + art.key)
/*     */       {
/*     */         
/*     */         public void set(WArmy t, int s)
/*     */         {
/* 267 */           (ADSupplies.ADArtillery.access$0(ADSupplies.ADArtillery.this)).artilleryTot.inc(t, -get(t));
/* 268 */           super.set(t, CLAMP.i(s, 0, max(t)));
/* 269 */           (ADSupplies.ADArtillery.access$0(ADSupplies.ADArtillery.this)).artilleryTot.inc(t, get(t));
/* 270 */           for (ADSupply ss : ADSupplies.ADArtillery.this.supplies) {
/* 271 */             ss.setChanged(t);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(WArmy t) {
/* 277 */           return get(t) + 40 - (ADSupplies.ADArtillery.access$0(ADSupplies.ADArtillery.this)).artilleryTot.get(t);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 282 */     for (int i = 0; i < art.constructor().resources(); i++) {
/* 283 */       RESOURCE res = art.constructor().resource(i);
/* 284 */       ADSupply.ADSupplyArt sup = new ADSupply.ADSupplyArt(sups.size(), init, this, res, i);
/* 285 */       this.supplies.add(sup);
/* 286 */       sups.add(sup);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int current(WArmy a) {
/* 292 */     double d = 1.0D;
/* 293 */     for (ADSupply ss : this.supplies) {
/* 294 */       d = Math.min(d, ss.amountValue(a));
/*     */     }
/* 296 */     if (a.state() != WArmyState.fortified)
/* 297 */       d *= 0.5D; 
/* 298 */     return (int)(this.target.get(a) * d);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 303 */     return this.art.typeIndex();
/*     */   }
/*     */   
/*     */   public LIST<ADSupply> sups() {
/* 307 */     return (LIST<ADSupply>)this.supplies;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupplies$ADArtillery.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */