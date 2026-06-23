/*    */ package view.ui.tech;
/*    */ import game.boosting.Boostable;
/*    */ import init.value.Lockable;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.employment.RoomEmployment;
/*    */ import settlement.room.main.employment.RoomEmploymentSimple;
/*    */ import settlement.room.main.employment.RoomEquip;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ 
/*    */ public class NodeBoosts {
/* 13 */   public final KeyMap<upEntry> upgradeBoost = new KeyMap();
/* 14 */   public final KeyMap<tEntry> tools = new KeyMap();
/*    */   
/*    */   NodeBoosts() {
/* 17 */     for (Industry ins : (SETT.ROOMS()).industries.all) {
/* 18 */       for (int i = 1; i <= ins.blue.upgrades().max(); i++) {
/* 19 */         String k = ((Lockable)(ins.blue.upgrades()).reqs.get(i - 1)).key;
/* 20 */         double v = ins.blue.upgrades().boost(i) - ins.blue.upgrades().boost(i - 1);
/* 21 */         if (!this.upgradeBoost.containsKey(k)) {
/* 22 */           upEntry e = new upEntry();
/* 23 */           e.blue = ins.blue;
/* 24 */           e.bo = ins.bonus();
/* 25 */           e.value = v;
/* 26 */           this.upgradeBoost.put(k, e);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 32 */     for (RoomEmployment emp : (SETT.ROOMS()).employment.ALL()) {
/* 33 */       for (RoomEquip t : emp.tools()) {
/* 34 */         tEntry e = new tEntry();
/* 35 */         e.blue = (RoomBlueprintImp)emp.blueprint();
/* 36 */         e.value = t;
/* 37 */         e.bo = e.blue.bonus();
/* 38 */         if (!this.tools.containsKey((t.target((RoomEmploymentSimple)emp).boost()).key))
/* 39 */           this.tools.put((t.target((RoomEmploymentSimple)emp).boost()).key, e); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class upEntry {
/*    */     public double value;
/*    */     public RoomBlueprintImp blue;
/*    */     public Boostable bo;
/*    */   }
/*    */   
/*    */   public static class tEntry {
/*    */     public RoomEquip value;
/*    */     public RoomBlueprintImp blue;
/*    */     public Boostable bo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\NodeBoosts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */