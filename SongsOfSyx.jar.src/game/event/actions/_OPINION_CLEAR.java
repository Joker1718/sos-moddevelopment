/*    */ package game.event.actions;
/*    */ 
/*    */ import game.boosting.superb.SuperBoostableObj;
/*    */ import game.boosting.superb.SuperSpec;
/*    */ import game.event.engine.EChoice;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.royalty.Royalty;
/*    */ import game.faction.royalty.opinion.ROPINION;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ final class _OPINION_CLEAR
/*    */   extends EventActionConstructor {
/*    */   _OPINION_CLEAR() {
/* 23 */     super("OPINION_REMOVE");
/*    */   }
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 28 */     return new Imp(this.key, data.parent, data.choice, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction {
/*    */     private final String[] keys;
/*    */     
/*    */     Imp(String key, Event parent, EChoice choice, Json data, LISTE<EventAction> all) {
/* 36 */       super(key, all);
/*    */       
/* 38 */       this.keys = data.texts("EVENTS");
/* 39 */       data.checkUnused();
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void exe(Event e, EContext data) {
/* 45 */       KeyMap<ArrayListGrower<SuperSpec.SuperSpecImp<Royalty>>> map = new KeyMap();
/*    */       
/* 47 */       for (SuperSpec.SuperSpecImp<Royalty> s : (Iterable<SuperSpec.SuperSpecImp<Royalty>>)ROPINION.BOOST().imps()) {
/*    */         
/* 49 */         if (!map.containsKey(s.key))
/* 50 */           map.put(this.key, new ArrayListGrower()); 
/* 51 */         ((ArrayListGrower)map.get(s.key)).add(s);
/*    */       }  byte b;
/*    */       int i;
/*    */       String[] arrayOfString;
/* 55 */       for (i = (arrayOfString = this.keys).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 56 */         if (map.containsKey(k))
/*    */         {
/* 58 */           for (SuperSpec.SuperSpecImp<Royalty> s : (Iterable<SuperSpec.SuperSpecImp<Royalty>>)map.get(k)) {
/* 59 */             for (FactionNPC reg : FACTIONS.NPCs()) {
/* 60 */               for (Royalty r : reg.court().all()) {
/* 61 */                 s.activate((SuperBoostableObj)r, false);
/*    */               }
/*    */             } 
/*    */           } 
/*    */         }
/*    */         b++; }
/*    */       
/* 68 */       super.exe(e, data);
/*    */     }
/*    */     
/*    */     public void hover(GBox b, Event event, EContext context) {}
/*    */     
/*    */     public void addToMessageBody(LISTE<RENDEROBJ> rows, Event event, EContext context, RECTANGLE messBody) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_OPINION_CLEAR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */