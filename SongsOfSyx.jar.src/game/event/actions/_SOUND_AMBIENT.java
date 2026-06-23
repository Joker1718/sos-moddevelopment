/*    */ package game.event.actions;
/*    */ 
/*    */ import game.audio.AUDIO;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import snake2d.SoundStream;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ final class _SOUND_AMBIENT
/*    */   extends EventActionConstructor
/*    */ {
/*    */   _SOUND_AMBIENT() {
/* 17 */     super("SOUND_AMBIENT");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 23 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction {
/*    */     private final LIST<SoundStream> stream;
/*    */     private final boolean city;
/*    */     private final boolean world;
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 33 */       super(key, all);
/* 34 */       this.stream = (AUDIO.AMBI()).factory.read(data);
/* 35 */       this.city = data.bool("CITY", true);
/* 36 */       this.world = data.bool("WORLD", false);
/* 37 */       data.checkUnused();
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void update(Event event, EContext e, double ds, double second) {
/* 44 */       if ((!this.city && VIEW.s().isActive()) || (VIEW.s()).battle.isActive()) {
/*    */         return;
/*    */       }
/* 47 */       if (!this.world && VIEW.world().isActive()) {
/*    */         return;
/*    */       }
/* 50 */       for (SoundStream s : this.stream) {
/* 51 */         s.play();
/*    */       }
/* 53 */       super.update(event, e, ds, second);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_SOUND_AMBIENT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */