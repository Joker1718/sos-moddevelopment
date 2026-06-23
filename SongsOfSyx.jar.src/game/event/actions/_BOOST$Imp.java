/*     */ package game.event.actions;
/*     */ 
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.event.engine.EChoice;
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Imp
/*     */   extends EventAction
/*     */ {
/*  65 */   public final BoostSpecs player = new BoostSpecs("", (SPRITE)(UI.icons()).s.time, false);
/*  66 */   public final BoostSpecs subjects = new BoostSpecs("", (SPRITE)(UI.icons()).s.time, false);
/*  67 */   public final BoostSpecs regions = new BoostSpecs("", (SPRITE)(UI.icons()).s.time, false);
/*     */   public final Event parent;
/*     */   public final EChoice choice;
/*     */   
/*     */   Imp(String key, Event parent, EChoice choice, Json data, LISTE<EventAction> all) {
/*  72 */     super(key, all);
/*  73 */     this.parent = parent;
/*  74 */     this.player.read("PLAYER", data, BValue.VALUE1);
/*  75 */     this.subjects.read("SUBJECTS", data, BValue.VALUE1);
/*  76 */     this.regions.read("REGIONS", data, BValue.VALUE1);
/*  77 */     this.choice = choice;
/*  78 */     param_BOOST.boosts.add(this);
/*  79 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {
/*  86 */     if (this.player.all().size() > 0) {
/*  87 */       this.player.hover((GUI_BOX)b, 1.0D, Dic.¤¤Boosts, -1);
/*     */     }
/*  89 */     if (this.subjects.all().size() > 0) {
/*  90 */       b.textLL(_BOOST.¤¤sTitle);
/*  91 */       b.add((SPRITE)GFORMAT.i(b.text(), STATS.EVENT().stat().data().get(null)));
/*  92 */       this.subjects.hover((GUI_BOX)b, 1.0D, null, -1);
/*     */     } 
/*  94 */     if (this.regions.all().size() > 0) {
/*  95 */       b.textLL(_BOOST.¤¤sTitleR);
/*  96 */       b.add((SPRITE)GFORMAT.i(b.text(), STATS.EVENT().stat().data().get(null)));
/*  97 */       this.regions.hover((GUI_BOX)b, 1.0D, null, -1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, Event event, final EContext context, RECTANGLE messBody) {
/* 103 */     GRows rr = (new GRows(6)).setMin(100);
/* 104 */     if (this.player.all().size() > 0) {
/* 105 */       rows.add(new GHeader(Dic.¤¤Boosts, (UI.FONT()).S));
/* 106 */       for (BoostSpec s : this.player.all()) {
/* 107 */         rr.add((RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 110 */                 s.booster.format(text, s.booster.getValue(1.0D));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GBox b) {
/* 115 */                 s.boostable.hover((GUI_BOX)b);
/*     */               }
/* 118 */             }).hh((SPRITE)s.boostable.icon));
/*     */       } 
/* 120 */       rows.add((Iterable)rr.rows());
/* 121 */       rr = (new GRows(6)).setMin(100);
/*     */     } 
/*     */     
/* 124 */     if (this.subjects.all().size() > 0 && context.indu.am > 0) {
/* 125 */       rows.add((new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 129 */               GFORMAT.i(text, context.indu.am);
/*     */             }
/* 131 */           }).hh(_BOOST.¤¤sTitle));
/*     */       
/* 133 */       for (BoostSpec s : this.subjects.all()) {
/* 134 */         rr.add((RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 137 */                 s.booster.format(text, s.booster.getValue(1.0D));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GBox b) {
/* 142 */                 s.boostable.hover((GUI_BOX)b);
/*     */               }
/* 145 */             }).hh((SPRITE)s.boostable.icon));
/*     */       } 
/* 147 */       rows.add((Iterable)rr.rows());
/* 148 */       rr = (new GRows(6)).setMin(100);
/*     */     } 
/*     */     
/* 151 */     if (this.regions.all().size() > 0 && context.regs.am > 0) {
/* 152 */       rows.add((new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 156 */               GFORMAT.i(text, context.regs.am);
/*     */             }
/* 158 */           }).hh(_BOOST.¤¤sTitleR));
/*     */       
/* 160 */       for (BoostSpec s : this.regions.all()) {
/* 161 */         rr.add((RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 164 */                 s.booster.format(text, s.booster.getValue(1.0D));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GBox b) {
/* 169 */                 s.boostable.hover((GUI_BOX)b);
/*     */               }
/* 172 */             }).hh((SPRITE)s.boostable.icon));
/*     */       } 
/* 174 */       rows.add((Iterable)rr.rows());
/* 175 */       rr = (new GRows(6)).setMin(100);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_BOOST$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */