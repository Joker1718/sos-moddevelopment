/*     */ package game.event.actions;
/*     */ 
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.RMAP;
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
/*     */   private final HTYPE immType;
/*  37 */   private final ArrayListGrower<_SUBJECTS_ADD.RAmount> datas = new ArrayListGrower();
/*     */ 
/*     */   
/*     */   Imp(String key, Json data, LISTE<EventAction> all) {
/*  41 */     super(key, all);
/*  42 */     this.immType = (HTYPE)HTYPES.MAP().readTry("IMMIGRANT_TYPE", data);
/*  43 */     RACES.map().getClass();
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
/*  54 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContext(Event event, EContext data) {
/*  59 */     for (_SUBJECTS_ADD.RAmount d : this.datas) {
/*  60 */       d.set(event, data, STATS.POP().pop(d.t, this.immType));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event event, EContext data) {
/*  68 */     for (_SUBJECTS_ADD.RAmount d : this.datas) {
/*  69 */       int am = d.amount.get(event, data);
/*  70 */       if (am > 0) {
/*  71 */         SETT.ENTRY().add(d.t, this.immType, am);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, final Event event, final EContext data, RECTANGLE messBody) {
/*  78 */     GRows rr = (new GRows(6)).setMin(100);
/*  79 */     for (_SUBJECTS_ADD.RAmount d : this.datas) {
/*     */       
/*  81 */       rr.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text) {
/*  84 */               GFORMAT.i(text, d.amount.get(event, data));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/*  90 */               b.title((CharSequence)b.text().add(d.t.info.names).s().add('(').add(_SUBJECTS_ADD.Imp.this.immType.names).add(')'));
/*  91 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), d.amount.get(event, data)));
/*  92 */               b.NL();
/*     */             }
/*  96 */           }).hh((SPRITE)(d.t.appearance()).icon));
/*     */     } 
/*  98 */     rows.add((Iterable)rr.rows());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {
/* 104 */     int t = 0;
/* 105 */     for (_SUBJECTS_ADD.RAmount d : this.datas) {
/*     */       
/* 107 */       if (t > 5) {
/* 108 */         t = 0;
/* 109 */         b.NL();
/*     */       } 
/* 111 */       b.tab(t * 3);
/* 112 */       t++;
/* 113 */       b.add((SPRITE)(d.t.appearance()).icon);
/* 114 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), d.amount.get(event, context)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence problem(Event event, EContext context) {
/* 120 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_SUBJECTS_ADD$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */