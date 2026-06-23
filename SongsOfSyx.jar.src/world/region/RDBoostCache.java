/*    */ package world.region;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.boosting.BOOSTING;
/*    */ import game.boosting.Boostable;
/*    */ import game.boosting.BoostableCat;
/*    */ import init.sprite.UI.Icon;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public class RDBoostCache
/*    */ {
/*    */   public final Boostable boost;
/*    */   
/*    */   public RDBoostCache(RD.RDInit init, String key, CharSequence name, CharSequence desc, Icon icon) {
/* 20 */     this(init, BOOSTING.push(key, 0.0D, name, desc, (SPRITE)icon, (BoostableCat.ALL()).WORLD_DUMP));
/*    */   }
/*    */   public final INT_O.INT_OE<Region> cache; public final INT_O.INT_OE<Region> value;
/*    */   public RDBoostCache(RD.RDInit init, Boostable boost) {
/* 24 */     this.boost = boost;
/* 25 */     this.cache = (INT_O.INT_OE<Region>)new DataO.DataBit(init.count, "CACHE" + boost.key);
/* 26 */     this.value = (INT_O.INT_OE<Region>)new DataO.DataNibble(init.count, "CACHEL" + boost.key);
/*    */   }
/*    */   
/*    */   public double get(Region reg) {
/* 30 */     if (reg == null)
/* 31 */       return 0.0D; 
/* 32 */     int upI = GAME.updateI() >> 5 & 0x1;
/* 33 */     if (this.cache.get(reg) != upI) {
/* 34 */       this.cache.set(reg, upI);
/*    */       
/* 36 */       double v = pget(reg);
/* 37 */       this.value.setD(reg, v);
/*    */     } 
/* 39 */     return this.value.getD(reg);
/*    */   }
/*    */   
/*    */   protected double pget(Region reg) {
/* 43 */     double v = this.boost.get((BOOSTABLE_O)reg);
/* 44 */     v = CLAMP.d(v, 0.0D, 1.0D);
/* 45 */     return v;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDBoostCache.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */