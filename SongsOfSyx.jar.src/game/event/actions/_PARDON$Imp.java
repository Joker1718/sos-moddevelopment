/*     */ package game.event.actions;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
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
/*     */   private final boolean useSelection;
/*     */   private final int amount;
/*     */   
/*     */   Imp(String key, Json data, LISTE<EventAction> all) {
/*  42 */     super(key, all);
/*  43 */     this.amount = data.i("PRISONER_TARGET", 1, 10000);
/*  44 */     this.useSelection = data.bool("USE_SELECTION", false);
/*  45 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event event, EContext data) {
/*  51 */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*  52 */     int ri = GAME.updateI();
/*  53 */     int am = 0;
/*  54 */     for (int i = 0; i < es.length; i++) {
/*  55 */       int ei = i + ri;
/*  56 */       ei = MATH.mod(ei, es.length);
/*     */       
/*  58 */       ENTITY e = es[ei];
/*  59 */       if (e instanceof Humanoid) {
/*  60 */         Humanoid a = (Humanoid)e;
/*  61 */         if (!this.useSelection || STATS.EVENT().has(a.indu())) {
/*     */           
/*  63 */           if (a.indu().hType() == HTYPES.PRISONER() && (AIModule_Prisoner.DATA()).punishmentSet.get(a.ai()) != CRIME_PUNISHMENTS.STOCKS()) {
/*  64 */             (AIModule_Prisoner.DATA()).punishmentSet.set(a.ai(), CRIME_PUNISHMENTS.STOCKS());
/*  65 */             am++;
/*     */           } 
/*  67 */           if (am >= this.amount || (this.useSelection && am >= data.indu.am)) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, Event event, EContext data, RECTANGLE messBody) {
/*  77 */     rows.add((new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  81 */             int am = 0;
/*  82 */             if (_PARDON.Imp.this.useSelection) {
/*  83 */               am = STATS.EVENT().stat().data().get(null);
/*     */             } else {
/*  85 */               am = _PARDON.Imp.this.amount;
/*     */             } 
/*  87 */             GFORMAT.i(text, -am);
/*     */           }
/*  89 */         }).hh((SPRITE)(UI.icons()).s.slave));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {
/*  95 */     int am = 0;
/*  96 */     if (this.useSelection) {
/*  97 */       am = STATS.EVENT().stat().data().get(null);
/*     */     } else {
/*  99 */       am = this.amount;
/*     */     } 
/* 101 */     b.add((SPRITE)(UI.icons()).s.slave);
/* 102 */     b.add((SPRITE)GFORMAT.i(b.text(), -am));
/* 103 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence problem(Event event, EContext context) {
/* 109 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_PARDON$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */