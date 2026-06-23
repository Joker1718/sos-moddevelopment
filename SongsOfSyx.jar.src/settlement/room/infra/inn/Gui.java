/*     */ package settlement.room.infra.inn;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.tourism.Review;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GStaples;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<InnInstance, ROOM_INN> {
/*  35 */   private static CharSequence ¤¤Guestbook = "Guestbook";
/*     */   
/*     */   static {
/*  38 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_INN s) {
/*  42 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<InnInstance> g, int x1, int y1) {
/*  48 */     GuiSection s = new GuiSection();
/*     */     
/*  50 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  54 */             GFORMAT.iIncr(text, ((InnInstance)g.get()).earnings);
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  58 */             GText t = b.text();
/*  59 */             DicTime.setYears((Str)t, -1.0D);
/*  60 */             b.add((SPRITE)t);
/*  61 */             b.add((SPRITE)GFORMAT.iIncr(b.text(), ((InnInstance)g.get()).earningsLast));
/*     */           }
/*  64 */         }).hv(Dic.¤¤Earnings));
/*     */ 
/*     */     
/*  67 */     section.addRelBody(32, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */     
/*  71 */     section.addRelBody(4, DIR.S, (RENDEROBJ)new GHeader(¤¤Guestbook));
/*     */ 
/*     */ 
/*     */     
/*  75 */     GRows gg = new GRows(2);
/*     */     
/*  77 */     for (int i = 0; i < 4; i++) {
/*  78 */       final int k = i;
/*     */       
/*  80 */       final RENDEROBJ.RenderImp rr = new RENDEROBJ.RenderImp(800, 400)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/*  84 */             Review rev = ((InnInstance)g.get()).reviews[k];
/*  85 */             if (rev != null && rev.has()) {
/*  86 */               rev.render(r, this.body.x1(), this.body.y1(), 800);
/*     */             }
/*     */           }
/*     */         };
/*     */       
/*  91 */       gg.add((RENDEROBJ)new GButt.ButtPanel((SPRITE)new SPRITE.Imp(100, 48)
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */               {
/*  95 */                 Review rev = ((InnInstance)g.get()).reviews[k];
/*  96 */                 if (rev != null && rev.has()) {
/*  97 */                   rev.renderScore(r, X1 + (X2 - X1) / 2, Y1 + 8);
/*  98 */                   rev.renderCred(r, X1 + 24, Y1 + 8 + 20);
/*     */                 } 
/*     */               }
/*     */             })
/*     */           {
/*     */             protected void renAction()
/*     */             {
/* 105 */               Review rev = ((InnInstance)g.get()).reviews[k];
/* 106 */               activeSet((rev != null && rev.has()));
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 111 */               Review rev = ((InnInstance)g.get()).reviews[k];
/* 112 */               if (rev == null || !rev.has())
/*     */                 return; 
/* 114 */               (VIEW.inters()).popup.show(rr, (CLICKABLE)this);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 121 */     for (RENDEROBJ o : gg.rows()) {
/* 122 */       section.addRelBody(4, DIR.S, o);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid grid, GGrid text, GuiSection sExtra) {
/* 132 */     GuiSection s = new GuiSection();
/*     */     
/* 134 */     final int am = (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN.historyRecords();
/* 135 */     GStaples chart = new GStaples(am)
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 139 */           int ago = am - 1 - stapleI;
/* 140 */           GText t = box.text();
/* 141 */           DicTime.setAgo((Str)t, ago * (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN.time().bitSeconds());
/* 142 */           box.textLL((CharSequence)t);
/* 143 */           box.NL();
/* 144 */           box.add((SPRITE)GFORMAT.iIncr(box.text(), (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN.get(ago)));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 150 */           return (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN.get(am - 1 - stapleI);
/*     */         }
/*     */       };
/* 153 */     chart.body().setDim(240.0D, 58.0D);
/*     */     
/* 155 */     s.add((RENDEROBJ)chart);
/* 156 */     s.addRelBody(4, DIR.N, (RENDEROBJ)new GHeader(Dic.¤¤Earnings));
/*     */     
/* 158 */     s.addRelBody(4, DIR.S, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤Tourists)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 162 */             (VIEW.UI()).tourists.activate();
/*     */           }
/* 165 */         }).pad(4, 1));
/*     */     
/* 167 */     text.add((RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableButt(GuiSection s, GETTER<RoomInstance> ins) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, InnInstance i) {
/* 179 */     InnInstance ii = i;
/*     */     
/* 181 */     box.NL();
/* 182 */     box.textLL(Dic.¤¤Earnings);
/* 183 */     box.add((SPRITE)GFORMAT.iIncr(box.text(), ii.earnings));
/* 184 */     box.NL();
/*     */   }
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */