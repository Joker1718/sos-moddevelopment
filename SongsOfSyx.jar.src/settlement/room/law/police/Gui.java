/*     */ package settlement.room.law.police;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpec;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.GUTIL;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<PoliceInstance, ROOM_POLICE> {
/*  38 */   private static CharSequence ¤¤suspects = "Suspects";
/*  39 */   private static CharSequence ¤¤AA = "Suspected Sloth";
/*  40 */   private static CharSequence ¤¤BB = "Suspected Witch";
/*  41 */   private static CharSequence ¤¤CC = "Suspected Warlock";
/*  42 */   private static CharSequence ¤¤DD = "Suspected Shapeshifter";
/*  43 */   private static CharSequence ¤¤EE = "Suspected Heretic";
/*  44 */   private static CharSequence ¤¤FF = "Suspected Beastialist";
/*  45 */   private static CharSequence ¤¤GG = "Suspected Turncoat";
/*  46 */   private static CharSequence ¤¤HH = "Suspected Renegade";
/*  47 */   private static CharSequence ¤¤II = "Suspected Collaborator";
/*     */   
/*  49 */   private static CharSequence ¤¤value = "The effect of your police force. Depends on the amount of police divided by the population to keep in check. Diminishing returns.";
/*     */   
/*  51 */   private static CharSequence[] tt = new CharSequence[] { ¤¤AA, ¤¤BB, ¤¤CC, ¤¤DD, ¤¤EE, ¤¤FF, ¤¤GG, ¤¤HH, ¤¤II };
/*     */   
/*     */   static {
/*  54 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_POLICE s) {
/*  58 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<PoliceInstance> g, int x1, int y1) {
/*  64 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  68 */           GUTIL.hList().clearSloppy();
/*  69 */           for (COORDINATE c : ((PoliceInstance)g.get()).body()) {
/*  70 */             if (((PoliceInstance)g.get()).is(c)) {
/*  71 */               Humanoid a = ((ROOM_POLICE)Gui.this.blueprint).work.client(c.x(), c.y());
/*  72 */               if (a != null)
/*  73 */                 GUTIL.hList().add(a); 
/*     */             } 
/*     */           } 
/*  76 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  81 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         
/*     */         public int nrOFEntries()
/*     */         {
/*  86 */           return GUTIL.hList().size();
/*     */         }
/*     */       };
/*     */     
/*  90 */     bu.column(¤¤suspects, 400, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/*  94 */             GButt.BSection r = new GButt.BSection()
/*     */               {
/*     */                 public void hoverInfoGet(GUI_BOX text)
/*     */                 {
/*  98 */                   if (ier.get() == null)
/*     */                     return; 
/* 100 */                   Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 101 */                   (VIEW.s()).ui.subjects.hoverInfo(h, (GBox)text);
/*     */                 }
/*     */               };
/*     */ 
/*     */             
/* 106 */             r.add((SPRITE)new GStat((UI.FONT()).H2)
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 110 */                     if (ier.get() == null)
/*     */                       return; 
/* 112 */                     Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 113 */                     text.lablify();
/* 114 */                     text.add(STATS.APPEARANCE().name(h.indu()));
/*     */                   }
/* 116 */                 }0, 0);
/*     */             
/* 118 */             r.addDown(2, (SPRITE)new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 122 */                     if (ier.get() == null)
/*     */                       return; 
/* 124 */                     Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 125 */                     text.warnify();
/* 126 */                     text.add(Gui.tt[STATS.RAN().get(h.indu(), 5) % Gui.tt.length]);
/*     */                   }
/*     */                 });
/*     */             
/* 130 */             r.addRelBody(8, DIR.W, (SPRITE)new SPRITE.Imp(40, 64)
/*     */                 {
/*     */                   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */                   {
/* 134 */                     if (ier.get() == null)
/*     */                       return; 
/* 136 */                     Humanoid h = (Humanoid)GUTIL.hList().get(((Integer)ier.get()).intValue());
/* 137 */                     STATS.APPEARANCE().portraitRender(r, h.indu(), X1, Y1, 1);
/*     */                   }
/*     */                 });
/*     */             
/* 141 */             r.body().setWidth(384.0D);
/*     */             
/* 143 */             r.pad(8, 3);
/*     */             
/* 145 */             return (RENDEROBJ)r;
/*     */           }
/*     */         });
/* 148 */     s.add((RENDEROBJ)bu.create(6, false));
/* 149 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid grid, GGrid text, GuiSection sExtra) {
/* 155 */     RENDEROBJ r = null;
/*     */     
/* 157 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 161 */           GFORMAT.perc(text, ((ROOM_POLICE)Gui.this.blueprint).value());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 166 */           b.text(Gui.¤¤value);
/* 167 */           b.NL(4);
/*     */           
/* 169 */           b.textLL(Dic.¤¤Employees);
/* 170 */           b.tab(6);
/* 171 */           GFORMAT.i(b.text(), ((ROOM_POLICE)Gui.this.blueprint).employment().employed());
/* 172 */           b.NL();
/*     */ 
/*     */           
/* 175 */           b.textLL(Dic.¤¤Population);
/* 176 */           b.NL();
/* 177 */           for (HCLASS_RACE r : HCLASS_RACE.REAL()) {
/* 178 */             if (((ROOM_POLICE)Gui.this.blueprint).access(r).is()) {
/* 179 */               b.tab(1).add(r.icon);
/* 180 */               b.tab(6);
/* 181 */               GFORMAT.i(b.text(), (STATS.POP()).POP.data(r.cl).get(r.race));
/* 182 */               b.NL();
/*     */             } 
/*     */           } 
/*     */           
/* 186 */           b.text(Dic.¤¤Value);
/* 187 */           b.tab(6);
/* 188 */           GFORMAT.perc(b.text(), ((ROOM_POLICE)Gui.this.blueprint).value());
/* 189 */           b.NL();
/*     */         }
/* 192 */       }).hh(Dic.¤¤Value);
/* 193 */     text.add((RENDEROBJ)hOVERABLE);
/*     */ 
/*     */     
/* 196 */     for (BoostSpec s : ((ROOM_POLICE)this.blueprint).spec.all()) {
/*     */       
/* 198 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 202 */             s.booster.format(text, s.get((BOOSTABLE_O)HCLASS_RACE.clP()));
/*     */           }
/* 206 */         }).hh(s.boostable.name);
/* 207 */       text.add((RENDEROBJ)hOVERABLE);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 215 */     GRows rr = new GRows(8);
/*     */     
/* 217 */     HCLASS prev = ((HCLASS_RACE)HCLASS_RACE.REAL().get(0)).cl;
/* 218 */     for (HCLASS_RACE cl : HCLASS_RACE.REAL()) {
/* 219 */       if (prev != cl.cl) {
/* 220 */         prev = cl.cl;
/* 221 */         rr.nl();
/*     */       } 
/* 223 */       if (cl.cl.player) {
/* 224 */         rr.add((RENDEROBJ)new GButt.ButtPanel(cl.icon)
/*     */             {
/*     */               protected void renAction()
/*     */               {
/* 228 */                 selectedSet(((ROOM_POLICE)Gui.this.blueprint).access(cl).is());
/* 229 */                 super.renAction();
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 234 */                 ((ROOM_POLICE)Gui.this.blueprint).access(cl).toggle();
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 239 */                 text.title(cl.name);
/* 240 */                 GBox b = (GBox)text;
/* 241 */                 b.textLL((BOOSTABLES.BEHAVIOUR()).SUBMISSION.name);
/* 242 */                 b.tab(6);
/* 243 */                 b.add((SPRITE)GFORMAT.perc(b.text(), (BOOSTABLES.BEHAVIOUR()).SUBMISSION.get((BOOSTABLE_O)cl)));
/* 244 */                 b.NL();
/*     */                 
/* 246 */                 b.textLL(Dic.¤¤Population);
/* 247 */                 b.tab(6);
/* 248 */                 b.add((SPRITE)GFORMAT.i(b.text(), (STATS.POP()).POP.data(cl.cl).get(cl.race)));
/* 249 */                 b.NL();
/*     */               }
/*     */             });
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 259 */     final CLICKABLE rt = (new GScrollRows((Iterable)rr.rows(), ((RENDEROBJ)rr.rows().get(0)).body().height() * 5)).view();
/*     */     
/* 261 */     text.add((RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Settings)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 265 */             (VIEW.inters()).popup.show(rt, (CLICKABLE)this);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, PoliceInstance i) {
/* 274 */     box.NL();
/* 275 */     box.text(¤¤suspects);
/* 276 */     box.add((SPRITE)GFORMAT.i(box.text(), i.prisoners));
/* 277 */     if ((S.get()).developer)
/* 278 */       box.add((SPRITE)GFORMAT.i(box.text(), i.prisonersMax())); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */