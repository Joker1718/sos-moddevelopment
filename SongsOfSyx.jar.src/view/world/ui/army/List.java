/*     */ package view.world.ui.army;
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import view.world.ui.WorldHoverer;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ final class List extends ISidePanel {
/*  47 */   private Faction f = (Faction)FACTIONS.player();
/*  48 */   private static int width = 200;
/*     */   private final GTableBuilder builder;
/*     */   
/*     */   public List() {
/*  52 */     titleSet(Dic.¤¤Armies);
/*     */ 
/*     */     
/*  55 */     int ww = 200;
/*     */     
/*  57 */     this.section.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  61 */             GFORMAT.iIncr(text, AD.conscripts().available(null).get(List.this.f));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  66 */             b.title(Dic.¤¤Conscriptable);
/*  67 */             b.text(Dic.¤¤ConscriptsD);
/*  68 */             b.NL(8);
/*     */             
/*  70 */             for (Race r : RACES.all()) {
/*  71 */               if ((r.population()).max == 0.0D)
/*     */                 continue; 
/*  73 */               b.add((SPRITE)(r.appearance()).icon);
/*  74 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), AD.conscripts().available(r).get(List.this.f)));
/*  75 */               b.NL();
/*     */             
/*     */             }
/*     */           
/*     */           }
/*  80 */         }).hh(Dic.¤¤Conscriptable, ww));
/*     */     
/*  82 */     this.section.addDownC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  87 */             int am = 0;
/*  88 */             for (ResSupply res : (RESOURCES.SUP()).ALL) {
/*  89 */               am += (SETT.ROOMS()).SUPPLY.tally.amount.total(res.resource);
/*     */             }
/*     */             
/*  92 */             GFORMAT.iIncr(text, am);
/*     */           }
/*     */           
/*  95 */           RBIT.RBITImp rs = new RBIT.RBITImp();
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  99 */             b.title(Dic.¤¤Supplies);
/* 100 */             b.text(Dic.¤¤SuppliesD);
/* 101 */             b.sep();
/*     */ 
/*     */             
/* 104 */             b.tab(1);
/* 105 */             b.textLL(Dic.¤¤Current);
/* 106 */             b.tab(4);
/* 107 */             b.textLL(Dic.¤¤Needed);
/* 108 */             b.tab(7);
/* 109 */             b.textLL(Dic.¤¤Consumed);
/* 110 */             b.tab(10);
/* 111 */             b.textLL(Dic.¤¤Available);
/* 112 */             b.NL();
/*     */             
/* 114 */             this.rs.clear();
/* 115 */             for (ResSupply supp : (RESOURCES.SUP()).ALL) {
/* 116 */               b.add((SPRITE)supp.resource.icon());
/* 117 */               ADSupply sup = AD.supplies().get(supp);
/* 118 */               b.tab(1);
/* 119 */               b.add((SPRITE)GFORMAT.i(b.text(), sup.current().faction(List.this.f)));
/* 120 */               b.tab(4);
/* 121 */               b.add((SPRITE)GFORMAT.i(b.text(), sup.targetAmount(List.this.f)));
/* 122 */               b.tab(7);
/* 123 */               b.add((SPRITE)GFORMAT.f0(b.text(), -sup.consumedPerDayCurrent(List.this.f)));
/* 124 */               b.tab(10);
/* 125 */               b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).SUPPLY.tally.amount.total(supp.resource)));
/* 126 */               b.NL();
/*     */             } 
/* 128 */             b.NL(8);
/*     */           }
/* 133 */         }).hh(Dic.¤¤Supplies, ww));
/*     */     
/* 135 */     this.section.addDownC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 139 */             GFORMAT.i(text, (AD.stats()).wins.f().get(List.this.f));
/*     */           }
/* 142 */         }).hh((AD.stats()).wins.name, ww).hoverInfoSet((AD.stats()).wins.desc));
/*     */     
/* 144 */     this.section.addDownC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 148 */             GFORMAT.i(text, (AD.stats()).siegeWon.f().get(List.this.f));
/*     */           }
/* 151 */         }).hh((AD.stats()).siegeWon.name, ww).hoverInfoSet((AD.stats()).siegeWon.desc));
/*     */     
/* 153 */     this.section.addDownC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 157 */             GFORMAT.i(text, (AD.stats()).defeats.f().get(List.this.f));
/*     */           }
/* 160 */         }).hh((AD.stats()).defeats.name, ww).hoverInfoSet((AD.stats()).defeats.desc));
/*     */     
/* 162 */     this.section.addDownC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 166 */             GFORMAT.i(text, (AD.stats()).kills.f().get(List.this.f));
/*     */           }
/* 169 */         }).hh((AD.stats()).kills.name, ww).hoverInfoSet((AD.stats()).kills.desc));
/*     */     
/* 171 */     this.section.addDownC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 175 */             GFORMAT.i(text, (AD.stats()).losses.f().get(List.this.f));
/*     */           }
/* 178 */         }).hh((AD.stats()).losses.name, ww).hoverInfoSet((AD.stats()).losses.desc));
/*     */     
/* 180 */     this.section.addDownC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 184 */             GFORMAT.percInc(text, AD.stats().repF().getD(List.this.f));
/*     */           }
/* 187 */         }).hh((AD.stats().repF().info()).name, ww).hoverInfoSet((AD.stats().repF().info()).desc));
/*     */     
/* 189 */     this.section.body().incrW(80.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     GButt.ButtPanel bb = new GButt.ButtPanel(Dic.¤¤Recruit)
/*     */       {
/* 197 */         PLACABLE p = (PLACABLE)new List.Placer();
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 201 */           activeSet(List.this.f.armies().canCreate());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 206 */           List.this.last().add(List.this, true);
/* 207 */           if (FACTIONS.player().armies().all().size() == 0) {
/* 208 */             COORDINATE c = WORLD.PATH().rnd(FACTIONS.player().capitolRegion());
/* 209 */             int tx = c.x();
/* 210 */             int ty = c.y();
/* 211 */             WArmy e = (WORLD.ENTITIES()).armies.create(tx, ty, (Faction)FACTIONS.player());
/* 212 */             (VIEW.world()).UI.armies.openList(e);
/*     */           } else {
/* 214 */             (VIEW.world()).tools.place(this.p);
/*     */           } 
/*     */         }
/*     */       };
/* 218 */     bb.body.setWidth(this.section.body().width());
/* 219 */     this.section.addDownC(4, (RENDEROBJ)bb);
/*     */ 
/*     */ 
/*     */     
/* 223 */     this.builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 227 */           return List.this.f.armies().all().size();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(int index) {
/* 232 */           if (index >= 0) {
/* 233 */             (WORLD.OVERLAY()).things.hover((RECTANGLE)((WArmy)List.this.f.armies().all().get(index)).body(), GCOLOR.MAP().get(List.this.f), false, 4);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 239 */     this.builder.column(null, width + 32, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/* 243 */             return (RENDEROBJ)new List.Button(ier);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 248 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)this.builder.createHeight(HEIGHT - this.section.getLastY2() - 8, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void set(WArmy a) {
/* 254 */     int i = 0;
/* 255 */     for (WArmy aa : this.f.armies().all()) {
/* 256 */       if (aa == a) {
/* 257 */         this.builder.set(i);
/*     */         break;
/*     */       } 
/* 260 */       i++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private class Button
/*     */     extends GButt.BSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     Button(GETTER<Integer> ier) {
/* 271 */       this.ier = ier;
/* 272 */       add((SPRITE)new GStat((UI.FONT()).M)
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 276 */               text.lablify();
/* 277 */               text.add((CharSequence)(List.Button.this.g()).name, 12);
/*     */             }
/* 279 */           }0, 0);
/*     */       
/* 281 */       addRightCAbs(List.width, (RENDEROBJ)new RENDEROBJ.RenderImp(16)
/*     */           {
/*     */             
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 286 */               if (List.Button.this.g().region() != null && DIP.WAR().is(List.Button.this.g().region().faction(), (Faction)GAME.player())) {
/* 287 */                 (GCOLOR.T()).IBAD.bind();
/* 288 */                 (SPRITES.icons()).s.world.render(r, (RECTANGLE)this.body);
/* 289 */                 COLOR.unbind();
/*     */               }
/* 291 */               else if (List.Button.this.g().path().moving(List.Button.this.g().body())) {
/* 292 */                 (SPRITES.icons()).s.crossheir.render(r, (RECTANGLE)this.body);
/* 293 */               } else if (List.Button.this.g().recruiting()) {
/* 294 */                 (SPRITES.icons()).s.muster.render(r, (RECTANGLE)this.body);
/*     */               } 
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 302 */       add((RENDEROBJ)new RENDEROBJ.RenderImp(body().width(), 12)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 306 */               double dw = AD.menTarget(null).get(List.Button.this.g()) / (Config.battle()).MEN_PER_ARMY;
/* 307 */               dw = Math.sqrt(dw);
/* 308 */               int ww = (int)(this.body.width() * dw);
/* 309 */               GMeter.renderDelta(r, AD.men(null).get(List.Button.this.g()) / AD.menTarget(null).get(List.Button.this.g()), 1.0D, this.body.x1(), this.body.x1() + ww, this.body.y1(), this.body.y2());
/*     */             }
/* 312 */           }0, body().y2() + 4);
/*     */ 
/*     */ 
/*     */       
/* 316 */       pad(6, 6);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 321 */       WorldHoverer.hover(text, (WEntity)g());
/*     */     }
/*     */     
/*     */     private WArmy g() {
/* 325 */       return (WArmy)List.this.f.armies().all().get(((Integer)this.ier.get()).intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 330 */       (VIEW.world()).UI.armies.openList(g(), List.this.last());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 335 */       selectedSet((List.this.last().added((VIEW.world()).UI.armies.army) && Army.army == g()));
/*     */     }
/*     */   }
/*     */   
/*     */   private class Placer
/*     */     extends PlacableSimpleTile {
/*     */     public Placer() {
/* 342 */       super(Dic.¤¤Recruit);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty) {
/* 347 */       if (!(WORLD.PATH()).map.is.is(tx, ty))
/* 348 */         return Dic.¤¤Unreachable; 
/* 349 */       if ((WORLD.REGIONS()).map.get(tx, ty) == null || ((Region)(WORLD.REGIONS()).map.get(tx, ty)).faction() != List.this.f)
/* 350 */         return Dic.¤¤MustBeOwnRegion; 
/* 351 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty) {
/* 356 */       WArmy e = (WORLD.ENTITIES()).armies.create(tx, ty, (Faction)FACTIONS.player());
/* 357 */       (VIEW.world()).tools.place(null);
/* 358 */       (VIEW.world()).UI.armies.openList(e);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderOverlay(GameWindow window) {
/* 364 */       WORLD.OVERLAY().hoverArmy((Faction)FACTIONS.player());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\List.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */