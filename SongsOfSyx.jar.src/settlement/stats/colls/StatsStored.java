/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import init.type.HCLASS;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.stat.STATFake;
/*    */ import settlement.stats.stat.StatCollection;
/*    */ import settlement.stats.stat.StatInfo;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ 
/*    */ public class StatsStored
/*    */   extends StatCollection {
/* 21 */   private static CharSequence ¤¤descc = "¤The amount of resources stored in warehouses per capita.";
/* 22 */   private static CharSequence ¤¤more = "¤{0}, we need more of it.";
/*    */   
/* 24 */   private static CharSequence ¤¤name = "Storage";
/* 25 */   private static CharSequence ¤¤desc = "How many items are stored per capita.";
/*    */   
/*    */   static {
/* 28 */     D.ts(StatsStored.class);
/*    */   }
/*    */   
/*    */   public StatsStored(StatsInit init) {
/* 32 */     super(init, "STORED", ¤¤name, ¤¤desc);
/* 33 */     D.t(this);
/*    */     
/* 35 */     for (RESOURCE res : RESOURCES.ALL()) {
/*    */       
/* 37 */       StatInfo info = new StatInfo(res.name, res.names, ¤¤descc);
/* 38 */       info.setOpinion(¤¤more, null);
/*    */       
/* 40 */       STATFake s = new STATFake(res.key, init, info)
/*    */         {
/*    */           protected double getDD(HCLASS s, Race r, int daysBack)
/*    */           {
/* 44 */             if (pdivider(null, null, daysBack) == 0)
/* 45 */               return (((SETT.ROOMS()).STOCKPILE.tally().amountsDay().get(res.bIndex()).get(daysBack) > 0) ? true : false); 
/* 46 */             return (SETT.ROOMS()).STOCKPILE.tally().amountsDay().get(res.bIndex()).get(daysBack) / pdivider(null, null, daysBack);
/*    */           }
/*    */         };
/* 49 */       (s.info()).icon = (SPRITE)res.icon();
/* 50 */       s.info().setMatters(true, false);
/* 51 */       s.info().setInt();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LIST<STAT> createTheOnesThatMatter(HCLASS cl) {
/* 59 */     ArrayList<STAT> res = new ArrayList(all().size());
/*    */     
/* 61 */     for (STAT s : all()) {
/* 62 */       boolean added = false;
/* 63 */       for (Race r : RACES.all()) {
/* 64 */         if (!added && s.standing().max(cl, r) > 0.0D) {
/* 65 */           res.add(s);
/* 66 */           added = true;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 73 */     return (LIST<STAT>)res;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsStored.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */