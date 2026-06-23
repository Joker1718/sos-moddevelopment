/*    */ package world.army;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ 
/*    */ public final class ADPower
/*    */ {
/*    */   private final INT_O.INT_OE<WArmy> carmy;
/*    */   private final INT_O.INT_OE<Faction> cfaction;
/*    */   private final INT_O.INT_OE<WArmy> army;
/*    */   private final INT_O.INT_OE<Faction> faction;
/*    */   
/*    */   ADPower(ADInit init) {
/* 19 */     init.dataA.getClass(); this.carmy = (INT_O.INT_OE<WArmy>)new DataO.DataBit(init.dataA, "CPOWER");
/* 20 */     init.dataT.getClass(); this.cfaction = (INT_O.INT_OE<Faction>)new DataO.DataBit(init.dataT, "CPOWER");
/*    */     
/* 22 */     init.dataA.getClass(); this.army = (INT_O.INT_OE<WArmy>)new DataO.DataInt(init.dataA, "POWER");
/* 23 */     init.dataT.getClass(); this.faction = (INT_O.INT_OE<Faction>)new DataO.DataInt(init.dataT, "POWER");
/*    */     
/* 25 */     init.countable.add(new ADInit.Countable()
/*    */         {
/*    */           public void count(WArmy a, int delta)
/*    */           {
/* 29 */             ADPower.this.mor(a);
/*    */           }
/*    */         });
/*    */     
/* 33 */     init.registers.add(new ADInit.Register()
/*    */         {
/*    */           public void register(ADDiv div, int d)
/*    */           {
/* 37 */             ADPower.this.mor(div.army());
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   void mor(WArmy a) {
/* 44 */     this.cfaction.set(a.faction(), 0);
/* 45 */     this.carmy.set(a, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(WArmy a) {
/* 50 */     if (this.carmy.get(a) == 0) {
/* 51 */       this.army.set(a, CLAMP.i((int)(GAME.battle()).power.get(a), 0, 2147483647));
/*    */     }
/* 53 */     this.carmy.inc(a, 1);
/* 54 */     return (int)Math.ceil(this.army.get(a) * morale(a));
/*    */   }
/*    */   
/*    */   public int get(Faction f) {
/* 58 */     if (this.cfaction.get(f) == 0) {
/*    */       
/* 60 */       int p = 0; int ai;
/* 61 */       for (ai = 0; ai < f.armies().all().size(); ai++) {
/* 62 */         WArmy a = (WArmy)f.armies().all().get(ai);
/* 63 */         p += get(a);
/*    */       } 
/* 65 */       this.cfaction.set(f, 1);
/* 66 */       this.faction.set(f, p);
/* 67 */       if (p < 0) {
/* 68 */         for (ai = 0; ai < f.armies().all().size(); ai++) {
/* 69 */           WArmy a = (WArmy)f.armies().all().get(ai);
/* 70 */           System.err.println("" + get(a) + " " + get(a));
/*    */         } 
/*    */       }
/*    */     } 
/* 74 */     return this.faction.get(f);
/*    */   }
/*    */   
/*    */   public double morale(WArmy a) {
/* 78 */     return CLAMP.d(AD.supplies().health(a) * (0.5D + 0.5D * AD.supplies().morale(a)), 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADPower.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */