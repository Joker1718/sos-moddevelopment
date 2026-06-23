/*     */ package view.battle.editor;
/*     */ 
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.battle.state.BattleStateSpec;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import menu.Menu;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import view.world.generator.WorldViewGenerator;
/*     */ import view.world.generator.tools.UIWorldGenerateTerrain;
/*     */ import world.WORLD;
/*     */ 
/*     */ class Placer
/*     */   extends PlacableSimpleTile
/*     */ {
/*  44 */   private static CharSequence ¤¤select = "Select Location";
/*  45 */   private static CharSequence ¤¤time = "time of day";
/*     */   static {
/*  47 */     D.ts(Placer.class);
/*     */   }
/*     */   
/*  50 */   private ArrayListGrower<CLICKABLE> butts = new ArrayListGrower();
/*  51 */   private final UIWorldGenerateTerrain terrain = new UIWorldGenerateTerrain(WORLD.GEN());
/*     */ 
/*     */ 
/*     */   
/*  55 */   public final ACTION generate = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  59 */         int time = RND.rInt(100);
/*  60 */         TIME.set((TIME.secondsPerDay() * time / 100));
/*  61 */         WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/*  62 */         WORLD.LANDMARKS().saver().generate(WorldViewGenerator.loadPrint);
/*  63 */         WorldViewGenerator.loadPrint.exe();
/*  64 */         WORLD.MINIMAP().repaint();
/*  65 */         WorldViewGenerator.loadPrint.exe();
/*  66 */         (WORLD.GEN()).hasGeneratedTerrain = true;
/*  67 */         (FACTIONS.otherFaction()).bonus.clear();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private final ArmySide player;
/*     */   
/*     */   private final ArmySide enemy;
/*     */   
/*     */   public Placer(ArmySide player, ArmySide enemy) {
/*  77 */     super(¤¤select);
/*     */     
/*  79 */     this.player = player;
/*  80 */     this.enemy = enemy;
/*     */     
/*  82 */     this.terrain.addRelBody(2, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Generate)
/*     */         {
/*     */           protected void clickA() {
/*  85 */             Placer.this.generate.exe();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  90 */     this.butts.add((new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_left)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  94 */             (VIEW.b()).editor.tools.placer.deactivate();
/*     */           }
/*  99 */         }).hoverInfoSet(Dic.¤¤Back));
/*     */     
/* 101 */     this.butts.add((new GButt.ButtPanel((SPRITE)(UI.icons()).m.terrain)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 105 */             (VIEW.inters()).popup.show((RENDEROBJ)Placer.this.terrain, (CLICKABLE)this);
/*     */           }
/* 110 */         }).hoverInfoSet(Dic.¤¤Generate));
/*     */ 
/*     */     
/* 113 */     INT.INTE ii = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 117 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 122 */           return 100;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 127 */           return CLAMP.i((int)(100.0D * TIME.currentSecond() / TIME.secondsPerDay()), 0, 100);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 132 */           TIME.set((TIME.secondsPerDay() * t) / 100.0D);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     GSliderInt sl = new GSliderInt(ii, 100, false)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 142 */           text.text(Placer.¤¤time);
/*     */         }
/*     */       };
/* 145 */     sl.addRelBody(4, DIR.W, (SPRITE)(UI.icons()).s.clock);
/*     */     
/* 147 */     sl.pad(8, 2);
/*     */     
/* 149 */     this.butts.add(sl);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 158 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 159 */       if (BattleState.okWorldTile(tx, ty, (DIR)DIR.ORTHO.get(i)))
/* 160 */         return null; 
/*     */     } 
/* 162 */     return Dic.empty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 167 */     BattleStateSpec spec = new BattleStateSpec();
/*     */     
/* 169 */     DIR d = (DIR)DIR.ORTHO.rnd();
/*     */     
/* 171 */     for (int i = 0; i < DIR.ORTHO.size() && 
/* 172 */       !BattleState.okWorldTile(tx, ty, d); i++)
/*     */     {
/* 174 */       d = d.next(2);
/*     */     }
/*     */ 
/*     */     
/* 178 */     set(this.player, spec.player, tx, ty);
/* 179 */     set(this.enemy, spec.enemy, tx + d.x(), ty + d.y());
/*     */     
/* 181 */     BattleStateExiter res = new BattleStateExiter()
/*     */       {
/*     */         public void afterExit(BattleStateResult res)
/*     */         {
/* 185 */           CORE.setCurrentState(new CORE_STATE.Constructor()
/*     */               {
/*     */                 public CORE_STATE getState() {
/* 188 */                   return (CORE_STATE)Menu.make();
/*     */                 }
/*     */               });
/*     */         }
/*     */       };
/*     */     
/* 194 */     BattleState.setGenerate(res, spec);
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(ArmySide s, BattleStateSpec.SpecSide ss, int tx, int ty) {
/* 199 */     for (int i = 0; i < ss.artillery.length; i++) {
/* 200 */       ss.artillery[i] = s.artillery[i];
/*     */     }
/* 202 */     ss.wCoo.set(tx, ty);
/* 203 */     ss.moraleBase = 1.0D;
/* 204 */     for (DIV_SPEC d : s.divs) {
/* 205 */       ss.divs.add(new DivGeneration(d, (DIV_SETTING)d));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int tx, int ty, int cx, int cy, boolean isPlacable) {
/* 211 */     super.renderPlaceHolder(r, tx, ty, cx, cy, isPlacable);
/* 212 */     if (!isPlacable) {
/* 213 */       (GCOLOR.MAP()).OK.bind();
/*     */     } else {
/* 215 */       (GCOLOR.MAP()).BAD.bind();
/*     */     } 
/* 217 */     int ri = (int)(64.0D * VIEW.renderSecond() * 0.5D);
/* 218 */     ri %= 64;
/* 219 */     ri = 64 - ri;
/* 220 */     for (DIR d : DIR.ORTHO)
/*     */     {
/* 222 */       (UI.icons()).s.chevron(d.perpendicular()).renderCScaled(r, cx + d.x() * 64 + d.x() * ri, cy + d.y() * 64 + d.y() * ri, 4);
/*     */     }
/*     */ 
/*     */     
/* 226 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 232 */     return (LIST<CLICKABLE>)this.butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */