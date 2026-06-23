/*    */ package settlement.room.industry.module;
/*    */ 
/*    */ import settlement.room.main.ROOMS;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public class RoomIndustries
/*    */ {
/*    */   public final LIST<Industry> all;
/*    */   
/*    */   public RoomIndustries(ROOMS rooms) {
/* 13 */     int am = 0;
/* 14 */     for (RoomBlueprint b : rooms.all()) {
/* 15 */       if (b instanceof INDUSTRY_HASER) {
/* 16 */         INDUSTRY_HASER h = (INDUSTRY_HASER)b;
/* 17 */         am += h.industries().size();
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 22 */     ArrayList<Industry> hh = new ArrayList(am);
/* 23 */     for (RoomBlueprint b : rooms.all()) {
/* 24 */       if (b instanceof INDUSTRY_HASER) {
/* 25 */         INDUSTRY_HASER h = (INDUSTRY_HASER)b;
/* 26 */         for (Industry i : h.industries()) {
/* 27 */           hh.add(i);
/*    */         }
/*    */       } 
/*    */     } 
/* 31 */     this.all = (LIST<Industry>)new ArrayList((Iterable)hh);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\RoomIndustries.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */