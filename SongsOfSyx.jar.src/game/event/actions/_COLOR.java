/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ final class _COLOR
/*    */   extends EventActionConstructor {
/*    */   _COLOR() {
/* 12 */     super("COLOR");
/*    */   }
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 17 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction {
/*    */     public final ColorImp color;
/*    */     private final boolean useSelection;
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 26 */       super(key, all);
/* 27 */       this.color = new ColorImp(data);
/* 28 */       this.useSelection = data.bool("USE_SELECTION", false);
/* 29 */       data.checkUnused();
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void exe(Event event, EContext data) {
/* 35 */       if (this.useSelection) {
/* 36 */         data.colorIndu = this.color;
/*    */       } else {
/* 38 */         data.colorinduAll = this.color;
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_COLOR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */