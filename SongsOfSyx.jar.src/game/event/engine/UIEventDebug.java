/*     */ package game.event.engine;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.event.actions.EventAction;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.constant.C;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.util.LinkedList;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ final class UIEventDebug
/*     */   extends GuiSection {
/*     */   public UIEventDebug(final EVENT_HANDLER en) {
/*  48 */     addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  52 */             if (en.current() == null) {
/*  53 */               text.add('-');
/*     */             } else {
/*  55 */               text.add((en.current()).key);
/*     */             }  }
/*  57 */         }).hh("current"));
/*     */     
/*  59 */     addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  63 */             if (en.current() == null)
/*     */               return; 
/*  65 */             text.add(en.timeElapsed());
/*  66 */             text.add('/');
/*  67 */             text.add((en.current()).duration.seconds);
/*     */           }
/*  69 */         }).hh("time"));
/*     */     
/*  71 */     addDown(2, (RENDEROBJ)new GButt.ButtPanel("Expire")
/*     */         {
/*     */           protected void clickA() {
/*  74 */             en.expire();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  79 */             activeSet((en.current() != null));
/*     */           }
/*     */         });
/*     */     
/*  83 */     addDown(2, (RENDEROBJ)new GButt.ButtPanel("#")
/*     */         {
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/*  88 */             for (String s : en.tags.keys()) {
/*  89 */               if (en.tags.get(s) == Boolean.TRUE) {
/*  90 */                 text.text(s);
/*     */               }
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/*  96 */     final GInput in = new GInput(new StringInputSprite(16, (UI.FONT()).S));
/*     */     
/*  98 */     addDown(2, (RENDEROBJ)in);
/*     */     
/* 100 */     LinkedList<RENDEROBJ> rows = new LinkedList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     for (Event a : Event.all) {
/*     */ 
/*     */ 
/*     */       
/* 109 */       SPRITE.Imp imp = new SPRITE.Imp(700, 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 113 */             int CY = Y1 + (Y2 - Y1) / 2;
/* 114 */             (en.can(a) ? COLOR.GREEN100 : COLOR.RED100).bind();
/* 115 */             (UI.icons()).s.dot.renderCY(r, X1 + 6, CY);
/* 116 */             COLOR.unbind();
/* 117 */             (UI.FONT()).S.renderCY(r, X1 + 32, CY, a.key);
/* 118 */             (GCOLOR.T()).H1.bind();
/* 119 */             (UI.FONT()).S.renderCY(r, X1 + 382, CY, a.info.name);
/* 120 */             Str.TMP.clear().add(en.acc(a), 2);
/* 121 */             COLOR.unbind();
/* 122 */             (UI.FONT()).S.renderCY(r, X2 - 64, CY, (CharSequence)Str.TMP);
/*     */           }
/*     */         };
/*     */       
/* 126 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)imp)
/*     */         {
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 132 */             GBox b = (GBox)text;
/*     */             
/* 134 */             UIEventDebug.this.hover(b, a);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 140 */             en.set(a, false, false, true, true);
/* 141 */             GuiSection pop = new GuiSection();
/* 142 */             EContext c = en.context();
/* 143 */             GText t = new GText((UI.FONT()).S, "indu: ");
/* 144 */             t.add(c.indu.am).s();
/* 145 */             int am = 0; int i;
/* 146 */             for (i = 0; i < (en.context()).indu.max(); i++) {
/* 147 */               Induvidual tt = c.indu.get(i);
/* 148 */               if (tt != null && c.indu.eventGet(tt) && 
/* 149 */                 am++ < 4) {
/* 150 */                 t.add(STATS.APPEARANCE().name(tt)).s();
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 155 */             t.s().add(am);
/* 156 */             t.adjustWidth();
/* 157 */             pop.addDownC(8, (SPRITE)t);
/*     */             
/* 159 */             t = new GText((UI.FONT()).S, "regs: ");
/* 160 */             t.add(c.regs.am).s();
/* 161 */             am = 0;
/* 162 */             for (i = 0; i < c.regs.max(); i++) {
/* 163 */               Region tt = c.regs.get(i);
/* 164 */               if (tt != null && c.regs.eventGet(tt) && 
/* 165 */                 am++ < 4) {
/* 166 */                 t.add((CharSequence)tt.info.name()).s();
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 171 */             t.s().add(am);
/* 172 */             t.adjustWidth();
/* 173 */             pop.addDownC(8, (SPRITE)t);
/*     */             
/* 175 */             t = new GText((UI.FONT()).S, "roys: ");
/* 176 */             t.add(c.royalty.am).s();
/* 177 */             am = 0;
/* 178 */             for (i = 0; i < c.royalty.max(); i++) {
/* 179 */               Royalty tt = c.royalty.get(i);
/* 180 */               if (tt != null && c.royalty.eventGet(tt) && 
/* 181 */                 am++ < 4) {
/* 182 */                 t.add(String.valueOf(tt.name()) + " (" + String.valueOf(tt.name()) + ") ");
/*     */               }
/*     */             } 
/*     */             
/* 186 */             t.s().add(am);
/* 187 */             t.adjustWidth();
/* 188 */             pop.addDownC(8, (SPRITE)t);
/*     */             
/* 190 */             t = new GText((UI.FONT()).S, "fact: ");
/* 191 */             t.add(c.faction.am).s();
/* 192 */             am = 0;
/* 193 */             for (i = 0; i < c.faction.max(); i++) {
/* 194 */               Faction tt = c.faction.get(i);
/* 195 */               if (tt != null && c.faction.eventGet(tt) && 
/* 196 */                 am++ < 4) {
/* 197 */                 t.add((CharSequence)tt.name).s();
/*     */               }
/*     */             } 
/*     */             
/* 201 */             t.s().add(am);
/* 202 */             t.adjustWidth();
/* 203 */             pop.addDownC(8, (SPRITE)t);
/*     */             
/* 205 */             (VIEW.inters()).popup2.show((RENDEROBJ)pop, (CLICKABLE)this);
/*     */           }
/*     */         };
/*     */       
/* 209 */       rows.add(buttPanel);
/*     */     } 
/*     */ 
/*     */     
/* 213 */     addDown(2, (RENDEROBJ)(new GScrollRows(rows, 400)
/*     */         {
/*     */           protected boolean passesFilter(int i, RENDEROBJ o)
/*     */           {
/* 217 */             if (in.text().length() == 0) {
/* 218 */               return true;
/*     */             }
/* 220 */             Event a = (Event)Event.all.get(i);
/* 221 */             return !(!Str.containsText(a.key, (CharSequence)in.text()) && !Str.containsText(a.info.name, (CharSequence)in.text()));
/*     */           }
/* 223 */         }).view());
/*     */     
/* 225 */     add((RENDEROBJ)new GPanel((RECTANGLE)body()));
/* 226 */     moveLastToBack();
/* 227 */     body().centerIn(C.DIM());
/*     */     
/* 229 */     IDebugPanel.add("event engine", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 233 */             (VIEW.inters()).section.activate(UIEventDebug.this);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private void hover(GBox b, Event a) {
/* 240 */     b.title(a.info.name);
/* 241 */     if (a.info.icon != null)
/* 242 */       b.add(a.info.icon); 
/* 243 */     b.NL(); byte b1; int i; CharSequence[] arrayOfCharSequence;
/* 244 */     for (i = (arrayOfCharSequence = a.info.messages).length, b1 = 0; b1 < i; ) { CharSequence s = arrayOfCharSequence[b1];
/* 245 */       b.text(s);
/* 246 */       b.NL(); b1++; }
/*     */     
/* 248 */     b.add((SPRITE)b.text().warnify().add(a.info.desc));
/* 249 */     b.NL();
/* 250 */     b.add((SPRITE)b.text().errorify().add(a.info.subject));
/* 251 */     b.NL();
/*     */     
/* 253 */     b.NL();
/* 254 */     b.textLL(Dic.¤¤Occurrence);
/* 255 */     b.NL();
/* 256 */     b.add((SPRITE)b.text().add(GAME.EVENT().can(a)));
/* 257 */     b.NL();
/* 258 */     int tt = 0;
/*     */     
/* 260 */     for (TERRAIN t : TERRAINS.ALL()) {
/* 261 */       if (tt > 6) {
/* 262 */         tt = 0;
/* 263 */         b.NL();
/*     */       } 
/* 265 */       b.add(t.icon());
/* 266 */       b.add((SPRITE)GFORMAT.f0(b.text(), a.occurence.toccurence[t.index()]));
/*     */     } 
/* 268 */     b.NL();
/* 269 */     for (Race rr : RACES.all()) {
/* 270 */       if (tt > 6) {
/* 271 */         tt = 0;
/* 272 */         b.NL();
/*     */       } 
/* 274 */       b.add((SPRITE)(rr.appearance()).icon);
/* 275 */       b.add((SPRITE)GFORMAT.f0(b.text(), a.occurence.roccurence[rr.index()]));
/*     */     } 
/* 277 */     b.NL();
/* 278 */     CLIMATE climate = SETT.ENV().climate();
/* 279 */     b.textLL((CLIMATES.INFO()).name);
/* 280 */     b.tab(6);
/* 281 */     b.add((SPRITE)GFORMAT.f0(b.text(), a.occurence.coccurence[climate.index()]));
/* 282 */     b.NL();
/* 283 */     b.textSLL(Dic.¤¤Total);
/* 284 */     b.tab(6);
/* 285 */     b.add((SPRITE)GFORMAT.f0(b.text(), a.occurence.occurence()));
/* 286 */     b.NL();
/* 287 */     b.text(Dic.¤¤Current);
/* 288 */     b.add((SPRITE)GFORMAT.iofk(b.text(), GAME.EVENT().occ(a), a.occurence.maxSpawns));
/* 289 */     b.NL();
/*     */ 
/*     */     
/* 292 */     a.occurence.plockable.hover((GUI_BOX)b, FACTIONS.player());
/* 293 */     b.NL();
/* 294 */     b.add((SPRITE)b.text().add(a.occurence.plockable.passes(FACTIONS.player())));
/*     */     
/* 296 */     b.sep();
/*     */     
/* 298 */     b.text("tags");
/* 299 */     b.add((SPRITE)b.text().add(a.tags.can((GAME.EVENT()).tags)));
/*     */     
/* 301 */     b.add((SPRITE)(UI.icons()).s.plus); byte b2; int j; String[] arrayOfString;
/* 302 */     for (j = (arrayOfString = a.tags.adds).length, b2 = 0; b2 < j; ) { String k = arrayOfString[b2];
/* 303 */       b.text(k); b2++; }
/*     */     
/* 305 */     b.NL();
/* 306 */     b.add((SPRITE)(UI.icons()).s.minus);
/* 307 */     for (j = (arrayOfString = a.tags.removes).length, b2 = 0; b2 < j; ) { String k = arrayOfString[b2];
/* 308 */       b.text(k); b2++; }
/*     */     
/* 310 */     b.NL();
/*     */     
/* 312 */     for (j = (arrayOfString = a.tags.allows).length, b2 = 0; b2 < j; ) { String k = arrayOfString[b2];
/* 313 */       if (!(GAME.EVENT()).tags.containsKey(k) || (GAME.EVENT()).tags.get(k) == Boolean.FALSE) {
/* 314 */         b.add((SPRITE)b.text().errorify().add(k));
/*     */       } else {
/* 316 */         b.add((SPRITE)b.text().normalify2().add(k));
/*     */       }  b2++; }
/* 318 */      b.NL();
/* 319 */     for (j = (arrayOfString = a.tags.allows_not).length, b2 = 0; b2 < j; ) { String k = arrayOfString[b2];
/* 320 */       if ((GAME.EVENT()).tags.containsKey(k) && (GAME.EVENT()).tags.get(k) == Boolean.TRUE) {
/* 321 */         b.add((SPRITE)b.text().errorify().add(k));
/*     */       } else {
/* 323 */         b.add((SPRITE)b.text().normalify2().add(k));
/*     */       }  b2++; }
/* 325 */      b.NL();
/* 326 */     b.sep();
/*     */ 
/*     */ 
/*     */     
/* 330 */     b.add((SPRITE)(UI.icons()).s.cancel);
/* 331 */     for (EventAction c : a.duration.on_expire)
/* 332 */       b.text(c.key); 
/* 333 */     b.NL();
/*     */ 
/*     */     
/* 336 */     for (EChoice ch : a.choices) {
/* 337 */       b.add((SPRITE)(UI.icons()).s.question);
/* 338 */       for (EventAction c : ch.actions)
/* 339 */         b.text(c.key); 
/* 340 */       b.NL();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 346 */     for (EventAction c : a.actions()) {
/* 347 */       b.text(c.key);
/* 348 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\UIEventDebug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */