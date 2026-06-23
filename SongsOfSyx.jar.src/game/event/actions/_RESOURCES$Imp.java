/*     */ package game.event.actions;
/*     */ 
/*     */ import game.event.engine.EContext;
/*     */ import game.event.engine.Event;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
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
/*     */ public final class Imp
/*     */   extends EventAction
/*     */ {
/*  43 */   private final ArrayListGrower<_RESOURCES.RAmount> datas = new ArrayListGrower();
/*     */   
/*     */   Imp(String key, Json data, LISTE<EventAction> all) {
/*  46 */     super(key, all);
/*  47 */     TR.MAP().getClass();
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
/*  59 */     data.checkUnused();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setContext(Event event, EContext data) {
/*  64 */     for (_RESOURCES.RAmount d : this.datas) {
/*  65 */       d.set(event, data, d.t.ps().playerOwned());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe(Event event, EContext data) {
/*  73 */     for (_RESOURCES.RAmount d : this.datas) {
/*  74 */       int am = d.amount.get(event, data);
/*  75 */       if (am < 0) {
/*  76 */         FACTIONS.player().seller(d.t).vanish(-am, FResources.RTYPE.DIPLOMACY); continue;
/*     */       } 
/*  78 */       if (am > 0) {
/*  79 */         FACTIONS.player().buyer(d.t).addReserve(am, TRADE_TYPE.diplomacy, 0, null);
/*  80 */         FACTIONS.player().buyer(d.t).addDeliver(am, TRADE_TYPE.diplomacy);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addToMessageBody(LISTE<RENDEROBJ> rows, final Event event, final EContext data, RECTANGLE messBody) {
/*  88 */     GRows rr = (new GRows(6)).setMin(100);
/*  89 */     for (_RESOURCES.RAmount d : this.datas) {
/*     */       
/*  91 */       rr.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text) {
/*  94 */               GFORMAT.i(text, d.amount.get(event, data));
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/*  99 */               b.title(d.t.names);
/* 100 */               int ava = d.t.ps().playerOwned();
/* 101 */               if (d.amount.get(event, data) < 0) {
/* 102 */                 b.textLL(Dic.¤¤Needed);
/* 103 */                 b.tab(6);
/* 104 */                 GText t = b.text();
/* 105 */                 b.add((SPRITE)GFORMAT.i(t, d.amount.get(event, data)));
/* 106 */                 if (ava < -d.amount.get(event, data))
/* 107 */                   t.errorify(); 
/* 108 */                 b.NL();
/*     */               } 
/*     */               
/* 111 */               b.textLL(Dic.¤¤Available);
/* 112 */               b.tab(6);
/*     */               
/* 114 */               b.add((SPRITE)GFORMAT.i(b.text(), ava));
/* 115 */               b.NL();
/*     */             }
/* 119 */           }).hh(d.t.icon()).hoverInfoSet(d.t.names));
/*     */     } 
/* 121 */     rows.add((Iterable)rr.rows());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox b, Event event, EContext context) {
/* 127 */     int t = 0;
/*     */ 
/*     */ 
/*     */     
/* 131 */     for (_RESOURCES.RAmount d : this.datas) {
/*     */       
/* 133 */       if (t > 5) {
/* 134 */         t = 0;
/* 135 */         b.NL();
/*     */       } 
/* 137 */       b.tab(t * 3);
/* 138 */       t++;
/* 139 */       b.add(d.t.icon());
/* 140 */       int ava = d.t.ps().playerOwned();
/*     */       
/* 142 */       GText te = b.text();
/* 143 */       GFORMAT.i(te, d.amount.get(event, context));
/* 144 */       if (d.amount.get(event, context) < 0 && -d.amount.get(event, context) > ava) {
/* 145 */         te.errorify();
/*     */       } else {
/* 147 */         te.normalify2();
/* 148 */       }  b.add((SPRITE)te);
/*     */       
/* 150 */       te = b.text();
/* 151 */       te.add('(');
/* 152 */       GFORMAT.i(te, ava);
/* 153 */       te.add(')');
/* 154 */       te.normalify();
/* 155 */       b.add((SPRITE)te);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence problem(Event event, EContext context) {
/* 163 */     for (_RESOURCES.RAmount d : this.datas) {
/*     */ 
/*     */       
/* 166 */       int ava = d.t.ps().playerOwned();
/* 167 */       if (d.amount.get(event, context) < 0 && -d.amount.get(event, context) > ava)
/* 168 */         return _RESOURCES.¤¤noEnough; 
/*     */     } 
/* 170 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_RESOURCES$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */