/*    */ package game.event.actions;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.EChoice;
/*    */ import game.event.engine.Event;
/*    */ import game.event.engine.EventCollection;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ public final class EventActions
/*    */ {
/* 16 */   private final KeyMap<EventActionConstructor> map = new KeyMap();
/*    */   
/*    */   private final EventCollection coll;
/*    */   
/*    */   public final _BOOST boosts;
/*    */   
/*    */   public EventActions(EventCollection coll) {
/* 23 */     register(new _PASTURE());
/* 24 */     register(new _ORCHARD());
/* 25 */     register(new _PARDON());
/* 26 */     register(new _INVASION());
/* 27 */     register(new _DESTRUCTION());
/* 28 */     register(new _OUTBREAK());
/* 29 */     register(new _RESOURCES());
/* 30 */     register(new _CREDITS());
/* 31 */     register(new _EARTHQUAKE());
/* 32 */     register(new _SUBJECTS_ADD());
/* 33 */     register(new _SUBJECTS_KILL());
/* 34 */     register(new _SOUND_AMBIENT());
/* 35 */     register(new _ALTER_SELECTION());
/* 36 */     register(new _COLOR());
/* 37 */     this.boosts = new _BOOST();
/* 38 */     register(this.boosts);
/* 39 */     register(new _EVENT());
/* 40 */     register(new _WEATHER());
/* 41 */     register(new _BOOST_PERM());
/* 42 */     register(new _BOOST_PERM_REMOVE());
/* 43 */     register(new _OPINION());
/* 44 */     register(new _OPINION_CLEAR());
/* 45 */     register(new _REGION_POP());
/* 46 */     this.coll = coll;
/*    */   }
/*    */   
/*    */   private void register(EventActionConstructor event) {
/* 50 */     this.map.put(event.key, event);
/*    */   }
/*    */   
/*    */   private static boolean hasWarned = false;
/*    */   
/*    */   public LIST<EventAction> get(Json[] jsons, Event parent, EChoice choice, LISTE<EventAction> all, boolean allow) {
/* 56 */     if (jsons == null)
/* 57 */       return (LIST<EventAction>)new ArrayList(0); 
/* 58 */     ArrayList<EventAction> res = new ArrayList(jsons.length);
/*    */     
/* 60 */     EventActionConstructor.Data data = new EventActionConstructor.Data();
/* 61 */     data.all = all;
/* 62 */     data.engine = this.coll;
/* 63 */     data.choice = choice;
/* 64 */     data.parent = parent; byte b;
/*    */     int i;
/*    */     Json[] arrayOfJson;
/* 67 */     for (i = (arrayOfJson = jsons).length, b = 0; b < i; ) { Json j = arrayOfJson[b];
/* 68 */       String t = j.value("TYPE");
/* 69 */       if (!this.map.containsKey(t))
/* 70 */       { String s = "There is no Action Type named " + t;
/* 71 */         if (!hasWarned) {
/* 72 */           hasWarned = true;
/* 73 */           s = s + s;
/* 74 */           s = s + "Available:";
/* 75 */           s = s + s;
/* 76 */           s = s + s;
/* 77 */           GAME.Warn(j.errorGet(s, "TYPE"));
/*    */         } else {
/* 79 */           LOG.err(j.errorGet(s, "TYPE"));
/*    */         }  }
/* 81 */       else { if (!allow && t.equals("EVENT")) {
/* 82 */           j.error("spawning an event here is not allowed", t);
/*    */         }
/* 84 */         boolean hideUI = j.bool("HIDE_UI", false);
/*    */         
/* 86 */         data.json = j;
/*    */         
/* 88 */         EventAction a = ((EventActionConstructor)this.map.get(t)).action(data);
/* 89 */         a.hideUI = hideUI;
/* 90 */         res.add(a); }
/*    */       
/*    */       b++; }
/*    */     
/* 94 */     return (LIST<EventAction>)res;
/*    */   }
/*    */   
/*    */   public void init() {
/* 98 */     _BOOST.init(this.coll);
/* 99 */     EventActionContext.check((LIST<Event>)this.coll.all);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\EventActions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */