/*    */ package game.faction.trade;
/*    */ import game.GAME;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.resources.RESOURCES;
/*    */ import init.resources.ResGEat;
/*    */ import init.trade.TR;
/*    */ import init.trade.TRADABLE;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import world.region.RD;
/*    */ 
/*    */ public final class ResourcePrices {
/*    */   private int[] lastCheck;
/*    */   private double[] price;
/*    */   
/*    */   public ResourcePrices() {
/* 18 */     this.lastCheck = Alloc.ii(TR.ALL().size());
/*    */     
/* 20 */     Arrays.fill(this.lastCheck, -16);
/*    */ 
/*    */     
/* 23 */     this.price = new double[TR.ALL().size()];
/*    */     
/* 25 */     this.echeck = -16;
/* 26 */     this.edible = 400;
/* 27 */     this.edibleLow = 50;
/*    */   } private int echeck; private int edible; private int edibleLow;
/*    */   public void clearCache() {
/* 30 */     Arrays.fill(this.lastCheck, -16);
/* 31 */     this.echeck = -16;
/*    */   }
/*    */   
/*    */   public int get(TRADABLE res) {
/* 35 */     if (FACTIONS.player() == null || FACTIONS.player().capitolRegion() == null) {
/* 36 */       return 400;
/*    */     }
/* 38 */     int ri = res.index();
/* 39 */     if (Math.abs(this.lastCheck[res.index()] - GAME.updateI()) > 16) {
/* 40 */       this.lastCheck[res.index()] = GAME.updateI();
/* 41 */       double a = 0.0D;
/* 42 */       this.price[ri] = 0.0D;
/* 43 */       for (int fi = 0; fi < FACTIONS.NPCs().size(); fi++) {
/* 44 */         FactionNPC f = (FactionNPC)FACTIONS.NPCs().get(fi);
/* 45 */         if (f.capitolRegion() != null) {
/*    */           
/* 47 */           double pop = (RD.RACES()).population.get(f.capitolRegion());
/* 48 */           if (f.seller(res).removeMax() > 0) {
/* 49 */             this.price[ri] = this.price[ri] + f.res(res).priceBase() * pop;
/* 50 */             a += pop;
/*    */           } 
/*    */         } 
/* 53 */       }  if (a == 0.0D) {
/* 54 */         this.price[ri] = 400.0D;
/*    */       } else {
/* 56 */         this.price[ri] = this.price[ri] / a;
/*    */       } 
/*    */     } 
/* 59 */     return (int)Math.ceil(this.price[res.index()]);
/*    */   }
/*    */   
/*    */   private void ee() {
/* 63 */     if (Math.abs(this.echeck - GAME.updateI()) > 16) {
/* 64 */       this.echeck = GAME.updateI();
/* 65 */       this.edible = 0;
/* 66 */       this.edibleLow = Integer.MAX_VALUE;
/* 67 */       for (int ei = 0; ei < RESOURCES.EDI().all().size(); ei++) {
/* 68 */         ResGEat e = (ResGEat)RESOURCES.EDI().all().get(ei);
/* 69 */         int p = get((TRADABLE)TR.get(e.resource));
/* 70 */         this.edibleLow = Math.min(p, this.edibleLow);
/* 71 */         this.edible += p;
/*    */       } 
/* 73 */       this.edible /= RESOURCES.EDI().all().size();
/*    */     } 
/*    */   }
/*    */   
/*    */   public int edible() {
/* 78 */     ee();
/* 79 */     return this.edible;
/*    */   }
/*    */   
/*    */   public int edibleLow() {
/* 83 */     ee();
/* 84 */     return this.edibleLow;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\ResourcePrices.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */