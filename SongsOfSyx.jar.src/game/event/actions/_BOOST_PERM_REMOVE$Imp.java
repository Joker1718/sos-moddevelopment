/*     */ package game.event.actions;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.tmp.TmpBoostSpec;
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.gui.misc.GBox;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Imp
/*     */   extends EventAction
/*     */ {
/*     */   private final String[] keys;
/*     */   
/*     */   Imp(String key, EventActionConstructor.Data data) {
/*  36 */     super(key, data.all);
/*     */     
/*  38 */     if (data.json.has("EVENTS")) {
/*  39 */       this.keys = data.json.values("EVENTS");
/*     */       
/*  41 */       for (int i = 0; i < this.keys.length; i++) {
/*  42 */         String k = this.keys[i];
/*  43 */         Event e = data.engine.read(data.parent, k, data.json, "EVENTS");
/*  44 */         if (e != null) {
/*  45 */           k = "EVENT_" + e.key;
/*     */         }
/*  47 */         this.keys[i] = k;
/*     */       } 
/*     */     } else {
/*  50 */       this.keys = null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  55 */     data.json.checkUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event e, EContext data) {
/*  61 */     if (this.keys != null) {
/*  62 */       KeyMap<ArrayListGrower<TmpBoostSpec>> map = new KeyMap();
/*     */       
/*  64 */       for (TmpBoostSpec s : GAME.BOOST().specs()) {
/*     */         
/*  66 */         if (!map.containsKey(s.key)) {
/*  67 */           map.put(s.key, new ArrayListGrower());
/*     */         }
/*  69 */         ((ArrayListGrower)map.get(s.key)).add(s);
/*     */       }  byte b;
/*     */       int i;
/*     */       String[] arrayOfString;
/*  73 */       for (i = (arrayOfString = this.keys).length, b = 0; b < i; ) { String k = arrayOfString[b];
/*  74 */         if (map.containsKey(k))
/*     */         {
/*  76 */           for (TmpBoostSpec s : map.get(k)) {
/*  77 */             for (Region reg : WORLD.REGIONS().all()) {
/*  78 */               (GAME.BOOST()).regions.set((INDEXED)reg, s, false);
/*     */             }
/*  80 */             for (HCLASS_RACE cl : HCLASS_RACE.ALL()) {
/*  81 */               (GAME.BOOST()).popcl.set((INDEXED)cl, s, false);
/*     */             }
/*  83 */             for (Faction reg : FACTIONS.all())
/*  84 */               (GAME.BOOST()).factions.set((INDEXED)reg, s, false); 
/*     */           } 
/*     */         }
/*     */         b++; }
/*     */     
/*     */     } else {
/*  90 */       for (Region reg : WORLD.REGIONS().all()) {
/*  91 */         (GAME.BOOST()).regions.clear((INDEXED)reg);
/*     */       }
/*  93 */       for (HCLASS_RACE cl : HCLASS_RACE.ALL()) {
/*  94 */         (GAME.BOOST()).popcl.clear((INDEXED)cl);
/*     */       }
/*  96 */       for (Faction reg : FACTIONS.all()) {
/*  97 */         (GAME.BOOST()).factions.clear((INDEXED)reg);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 103 */     super.exe(e, data);
/*     */   }
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {}
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, Event event, EContext data, RECTANGLE messBody) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_BOOST_PERM_REMOVE$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */