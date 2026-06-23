/*     */ package menu;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FACTIONS;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.menu.MenuScreen;
/*     */ 
/*     */ class ScRandomSettings
/*     */   extends GUI.Shadower
/*     */   implements SC {
/*  32 */   public final KeyMap<Double> ADD = new KeyMap();
/*  33 */   public final KeyMap<Double> MUL = new KeyMap();
/*     */   
/*     */   private CharSequence desc;
/*  36 */   static CharSequence ¤¤name = "¤Game Config";
/*  37 */   private static CharSequence ¤¤ok = "ok";
/*  38 */   private static CharSequence ¤¤clear = "clear!";
/*     */   
/*     */   static {
/*  41 */     D.ts(ScRandomSettings.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ScRandomSettings(final Menu menu) {
/*  49 */     MenuScreen screen = new MenuScreen(¤¤name, GUI.labelColor)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  53 */           menu.switchScreen(menu.sandbox2);
/*     */         }
/*     */       };
/*     */     
/*  57 */     add((RENDEROBJ)screen);
/*     */     
/*  59 */     screen.addButt((RENDEROBJ)new MenuScreen.ScreenButton(¤¤ok)
/*     */         {
/*     */           protected void clickA() {
/*  62 */             menu.switchScreen(menu.sandbox2);
/*     */           }
/*     */         });
/*     */     
/*  66 */     screen.addButt((RENDEROBJ)new MenuScreen.ScreenButton(¤¤clear)
/*     */         {
/*     */           protected void clickA() {
/*  69 */             for (String s : ScRandomSettings.this.ADD.keys()) {
/*  70 */               ScRandomSettings.this.ADD.putReplace(s, Double.valueOf(0.0D));
/*  71 */               ScRandomSettings.this.MUL.putReplace(s, Double.valueOf(1.0D));
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  78 */     GuiSection options = new GuiSection();
/*     */     
/*  80 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  82 */     for (BoostableCat cat : BOOSTABLES.colls()) {
/*     */       
/*  84 */       if (cat == BOOSTABLES.PHYSICS()) {
/*     */         continue;
/*     */       }
/*  87 */       if (cat.all().size() == 0) {
/*     */         continue;
/*     */       }
/*  90 */       rows.add(new HOVERABLE.Sprite((UI.FONT()).H2.getText(cat.name), GUI.COLORS.label));
/*     */ 
/*     */ 
/*     */       
/*  94 */       for (Boostable b : cat.all()) {
/*  95 */         this.ADD.put(b.key, Double.valueOf(0.0D));
/*  96 */         this.MUL.put(b.key, Double.valueOf(1.0D));
/*  97 */         GuiSection s = new GuiSection()
/*     */           {
/*     */             public boolean hover(COORDINATE mCoo)
/*     */             {
/* 101 */               if (super.hover(mCoo)) {
/* 102 */                 ScRandomSettings.this.desc = b.desc;
/* 103 */                 return true;
/*     */               } 
/* 105 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public void render(SPRITE_RENDERER r, float ds) {
/* 110 */               if (hoveredIs()) {
/* 111 */                 COLOR.WHITE100.render(r, body().x1(), body().x2(), body().y2() - 2, body().y2() - 1);
/*     */               }
/* 113 */               super.render(r, ds);
/*     */             }
/*     */           };
/*     */         
/* 117 */         final GText str = new GText((UI.FONT()).M, 16);
/* 118 */         s.add(GUI.getSmallText(b.name), 0, 0);
/*     */         
/* 120 */         s.addRightCAbs(350, (RENDEROBJ)new GUI.Button((UI.FONT()).M.getText("<<"))
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 124 */                 ScRandomSettings.this.ADD.putReplace(b.key, Double.valueOf(((Double)ScRandomSettings.this.ADD.get(b.key)).doubleValue() - 0.25D));
/* 125 */                 super.clickA();
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 130 */         s.addRightC(8, (SPRITE)new SPRITE.Imp(100, 16)
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */               {
/* 134 */                 double d = ((Double)ScRandomSettings.this.ADD.get(b.key)).doubleValue();
/* 135 */                 str.clear();
/* 136 */                 GFORMAT.f0(str, d);
/* 137 */                 str.adjustWidth();
/* 138 */                 str.renderC(r, X1, X2, Y1, Y2);
/*     */               }
/*     */             });
/* 141 */         s.addRightCAbs(100, (RENDEROBJ)new GUI.Button(GUI.getSmallText(">>"))
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 145 */                 ScRandomSettings.this.ADD.putReplace(b.key, Double.valueOf(((Double)ScRandomSettings.this.ADD.get(b.key)).doubleValue() + 0.25D));
/* 146 */                 super.clickA();
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 151 */         s.addRightC(32, (RENDEROBJ)new GUI.Button(GUI.getSmallText("<<"))
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 155 */                 ScRandomSettings.this.MUL.putReplace(b.key, Double.valueOf(((Double)ScRandomSettings.this.MUL.get(b.key)).doubleValue() - 0.1D));
/* 156 */                 super.clickA();
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 161 */         s.addRightC(8, (SPRITE)new SPRITE.Imp(100, 16)
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */               {
/* 165 */                 double d = ((Double)ScRandomSettings.this.MUL.get(b.key)).doubleValue();
/* 166 */                 if (d < 0.0D)
/* 167 */                   d = 0.0D; 
/* 168 */                 str.clear();
/* 169 */                 GFORMAT.f0(str, d, 2.0D);
/* 170 */                 str.clear();
/* 171 */                 str.add('x');
/* 172 */                 str.add(d);
/* 173 */                 str.adjustWidth();
/* 174 */                 str.renderC(r, X1, X2, Y1, Y2);
/*     */               }
/*     */             });
/* 177 */         s.addRightCAbs(100, (RENDEROBJ)new GUI.Button(GUI.getSmallText(">>"))
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 181 */                 ScRandomSettings.this.MUL.putReplace(b.key, Double.valueOf(((Double)ScRandomSettings.this.MUL.get(b.key)).doubleValue() + 0.1D));
/* 182 */                 super.clickA();
/*     */               }
/*     */             });
/*     */         
/* 186 */         s.pad(8, 2);
/* 187 */         rows.add(s);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 192 */     if ((PATHS.local()).PROFILE.exists("MODE_SETTINGS")) {
/* 193 */       Json j = new Json((PATHS.local()).PROFILE.gets("MODE_SETTINGS"));
/* 194 */       Json a = j.json("ADD");
/* 195 */       for (String k : a.keys()) {
/* 196 */         if (this.ADD.containsKey(k))
/* 197 */           this.ADD.putReplace(k, Double.valueOf(CLAMP.d(a.d(k), -10000.0D, 10000.0D))); 
/* 198 */       }  a = j.json("MUL");
/* 199 */       for (String k : a.keys()) {
/* 200 */         if (this.MUL.containsKey(k))
/* 201 */           this.MUL.putReplace(k, Double.valueOf(CLAMP.d(a.d(k), 0.0D, 10000.0D))); 
/*     */       } 
/*     */     } 
/* 204 */     options.add((RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 16)).view());
/*     */ 
/*     */ 
/*     */     
/* 208 */     options.addRelBody(8, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(MenuScreen.inner.width() - 4, 64) {
/* 209 */           GText str = new GText((UI.FONT()).M, 128);
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 212 */             COLOR.WHITE150.bind();
/* 213 */             if (ScRandomSettings.this.desc != null) {
/* 214 */               this.str.clear().add(ScRandomSettings.this.desc);
/* 215 */               this.str.setMultipleLines(true);
/* 216 */               this.str.setMaxWidth(800);
/* 217 */               this.str.renderC(r, (RECTANGLE)this.body);
/*     */             } 
/* 219 */             COLOR.unbind();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 225 */     options.body().centerIn((RECTANGLE)body());
/*     */     
/* 227 */     add((RENDEROBJ)options);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/* 233 */     menu.switchScreen(menu.sandbox2);
/* 234 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save() {
/* 239 */     JsonE a = new JsonE();
/* 240 */     JsonE m = new JsonE();
/*     */     
/* 242 */     for (String k : this.MUL.keysSorted()) {
/*     */       
/* 244 */       double d = ((Double)this.MUL.get(k)).doubleValue();
/* 245 */       if (d != 1.0D)
/* 246 */         m.add(k, d); 
/* 247 */       d = ((Double)this.ADD.get(k)).doubleValue();
/* 248 */       if (d != 0.0D) {
/* 249 */         a.add(k, d);
/*     */       }
/*     */     } 
/* 252 */     JsonE j = new JsonE();
/* 253 */     j.add("ADD", a);
/* 254 */     j.add("MUL", m);
/*     */     
/* 256 */     (PATHS.local()).PROFILE.create("MODE_SETTINGS");
/*     */     
/* 258 */     j.save((PATHS.local()).PROFILE.get("MODE_SETTINGS"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void apply() {
/* 267 */     for (String k : this.MUL.keys()) {
/* 268 */       double m = ((Double)this.MUL.get(k)).doubleValue();
/* 269 */       double a = ((Double)this.ADD.get(k)).doubleValue();
/* 270 */       if (m != 1.0D) {
/* 271 */         (FACTIONS.player()).bonusesCustom.add(k, m, true);
/*     */       }
/* 273 */       if (a != 0.0D)
/* 274 */         (FACTIONS.player()).bonusesCustom.add(k, a, false); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScRandomSettings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */