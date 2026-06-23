/*    */ package init.type;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.boosting.BoosterImp;
/*    */ import game.faction.Faction;
/*    */ import game.time.TIME;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Event
/*    */   extends BoosterImp
/*    */ {
/*    */   private final int day;
/*    */   private final int days;
/*    */   
/*    */   public Event(int day, int days, NEED need) {
/* 82 */     super(new BSourceInfo(NEEDS.¤¤event, (SPRITE)(UI.icons()).s.arrowUp), 1.0D, need.event, true);
/* 83 */     this.day = day;
/* 84 */     this.days = days;
/* 85 */     add(need.rate);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Faction f) {
/* 90 */     return ((TIME.days().bitsSinceStart() % this.days == this.day) ? true : false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\NEEDS$Event.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */