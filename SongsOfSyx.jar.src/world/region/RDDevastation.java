/*    */ package world.region;
/*    */ 
/*    */ import game.boosting.BOOSTING;
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.time.TIME;
/*    */ import init.resources.RESOURCES;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
/*    */ import util.text.D;
/*    */ import world.WORLD;
/*    */ import world.entity.army.WArmy;
/*    */ import world.map.regions.Region;
/*    */ import world.region.pop.RDRace;
/*    */ 
/*    */ 
/*    */ public class RDDevastation
/*    */ {
/* 23 */   private static CharSequence ¤¤Name = "¤Devastation";
/* 24 */   private static CharSequence ¤¤Desc = "¤Devastation comes from military actions. Devastated regions produce less, and have slower population growth. Devastation takes 2 years to subside.";
/*    */   
/*    */   static {
/* 27 */     D.ts(RDDevastation.class);
/*    */   }
/*    */   
/* 30 */   private static final double dTime = 1.0D / (TIME.secondsPerDay() * 32);
/*    */   
/*    */   public final INT_O.INT_OE<Region> current;
/*    */   
/*    */   RDDevastation(RD.RDInit init) {
/* 35 */     init.count.getClass(); this.current = (INT_O.INT_OE<Region>)new DataO.DataShort(init.count, "DEVASTATION", ¤¤Name, ¤¤Desc);
/*    */ 
/*    */     
/* 38 */     BOOSTING.connecter(new ACTION()
/*    */         {
/*    */           public void exe()
/*    */           {
/* 42 */             RBooster b = new RBooster(new BSourceInfo(RDDevastation.¤¤Name, (SPRITE)(UI.icons()).s.heat), 0.25D, 1.0D, true)
/*    */               {
/*    */                 public double get(Region t)
/*    */                 {
/* 46 */                   return 1.0D - (RDDevastation.null.access$0(RDDevastation.null.this)).current.getD(t);
/*    */                 }
/*    */               };
/*    */             
/* 50 */             b.add((RD.RACES()).capacity);
/*    */             
/* 52 */             for (RDRace r : (RD.RACES()).all) {
/* 53 */               b.add(r.pop.growth);
/*    */             }
/*    */             
/* 56 */             for (RDOutputs.RDOutput o : (RD.OUTPUT()).ALL) {
/* 57 */               b.add(o.boost);
/* 58 */               b.add(o.boostYearlyPart);
/*    */             } 
/*    */           }
/*    */         });
/*    */ 
/*    */     
/* 64 */     init.upers.add(new RD.RDUpdatable()
/*    */         {
/*    */           public void update(Region reg, double time)
/*    */           {
/* 68 */             if (reg.faction() != null) {
/* 69 */               for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/* 70 */                 if (a.raiding())
/*    */                   return; 
/*    */               } 
/* 73 */               RDDevastation.this.current.incFraction(reg, -RDDevastation.this.current.max(reg) * time * RDDevastation.dTime);
/*    */             } 
/*    */           }
/*    */ 
/*    */           
/*    */           public void init(Region reg) {
/* 79 */             RDDevastation.this.current.set(reg, 0);
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public int raidCredits(Region reg) {
/* 86 */     double pop = (RD.RACES()).population.get(reg);
/* 87 */     double d = pop * RESOURCES.ALL().size();
/* 88 */     if (reg.faction() != null && reg.faction() instanceof FactionNPC) {
/* 89 */       FactionNPC f = (FactionNPC)reg.faction();
/* 90 */       d *= 1.0D + CLAMP.d(f.credits().credits() / (RD.RACES()).population.faction().get(f), 0.0D, 100.0D);
/*    */     } 
/* 92 */     return (int)(d * (1.0D - this.current.getD(reg)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDDevastation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */