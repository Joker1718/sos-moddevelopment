/*     */ package settlement.room.main.copy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class BSwap
/*     */ {
/*  26 */   private final KeyMap<GuiSection> otherPrints = new KeyMap();
/*     */   private CLICKABLE button;
/*     */   private RoomBlueprintImp current;
/*  29 */   private final ArrayListResize<CLICKABLE> wrap = new ArrayListResize(4, 16);
/*     */   
/*  31 */   private static CharSequence ¤¤swap = "¤Switch to another type of room.";
/*     */   static {
/*  33 */     D.ts(BSwap.class);
/*     */   }
/*     */   
/*     */   BSwap(ROOMS m) {
/*  37 */     SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  41 */           BSwap.this.current.iconBig().renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/*  42 */           (SPRITES.icons()).m.rotate.renderC(r, X1 + (X2 - X1) / 2, Y1 + (Y2 - Y1) / 2);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  47 */     this.button = (new GButt.ButtPanel((SPRITE)imp)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  51 */           (VIEW.inters()).popup.show((RENDEROBJ)BSwap.this.alt(), (CLICKABLE)this);
/*     */         }
/*  54 */       }).setDim(36).hoverInfoSet(¤¤swap);
/*     */     
/*  56 */     for (int i = 0; i < m.all().size(); i++) {
/*  57 */       RoomBlueprint p = (RoomBlueprint)m.all().get(i);
/*  58 */       if (p instanceof RoomBlueprintIns)
/*  59 */         addGroup((RoomBlueprintIns)p, m); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private GuiSection alt() {
/*  64 */     return (GuiSection)this.otherPrints.get(this.current.key);
/*     */   }
/*     */   
/*     */   void init(RoomBlueprintImp bb) {
/*  68 */     this.current = bb;
/*  69 */     if (bb.reqs.passes(FACTIONS.player())) {
/*     */       return;
/*     */     }
/*     */     
/*  73 */     for (RoomBlueprint p : SETT.ROOMS().all()) {
/*  74 */       if (p instanceof RoomBlueprintIns) {
/*  75 */         RoomBlueprintIns<?> ins = (RoomBlueprintIns)p;
/*  76 */         if (ins.getClass() == bb.getClass() && ins.constructor().mustBeIndoors() == bb.constructor().mustBeIndoors() && ins.reqs.passes(FACTIONS.player())) {
/*  77 */           this.current = (RoomBlueprintImp)ins;
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   LIST<CLICKABLE> wrap(LIST<CLICKABLE> others) {
/*  86 */     this.wrap.clearSoft();
/*  87 */     if (others != null)
/*  88 */       this.wrap.add((Iterable)others); 
/*  89 */     if (alt() != null) {
/*  90 */       this.wrap.add(this.button);
/*     */     }
/*  92 */     return (LIST<CLICKABLE>)this.wrap;
/*     */   }
/*     */   
/*     */   RoomBlueprintImp current() {
/*  96 */     return this.current;
/*     */   }
/*     */   
/*     */   private void addGroup(RoomBlueprintIns<?> blue, ROOMS m) {
/* 100 */     if (this.otherPrints.get(blue.key) != null)
/*     */       return; 
/* 102 */     if (!blue.constructor().usesArea()) {
/*     */       return;
/*     */     }
/*     */     
/* 106 */     LinkedList<RoomBlueprintImp> res = new LinkedList();
/*     */     
/* 108 */     for (RoomBlueprint p : m.all()) {
/* 109 */       if (p instanceof RoomBlueprintIns) {
/* 110 */         RoomBlueprintIns<?> ins = (RoomBlueprintIns)p;
/* 111 */         if (ins.getClass() == blue.getClass() && ins.constructor().mustBeIndoors() == blue.constructor().mustBeIndoors()) {
/* 112 */           res.add(ins);
/*     */         }
/*     */       } 
/*     */     } 
/* 116 */     if (res.size() <= 1) {
/*     */       return;
/*     */     }
/* 119 */     GuiSection s = new GuiSection();
/*     */     
/* 121 */     for (RoomBlueprintImp p : res) {
/* 122 */       GButt.Panel panel = new GButt.Panel((SPRITE)p.iconBig(), p.info.name)
/*     */         {
/*     */           
/*     */           protected void renAction()
/*     */           {
/* 127 */             selectedSet((BSwap.this.current == p));
/* 128 */             activeSet(p.reqs.passes(FACTIONS.player()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 133 */             text.title(p.info.name);
/* 134 */             text.text(p.info.desc);
/* 135 */             text.NL();
/*     */             
/* 137 */             if (!p.reqs.passes(FACTIONS.player())) {
/* 138 */               p.reqs.hover(text, FACTIONS.player());
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 144 */             if (p.reqs.passes(FACTIONS.player()))
/* 145 */               BSwap.this.current = p; 
/* 146 */             (VIEW.inters()).popup.close();
/*     */           }
/*     */         };
/*     */       
/* 150 */       s.addDownC(0, (RENDEROBJ)panel);
/*     */     } 
/*     */     
/* 153 */     this.otherPrints.put(blue.key, s);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\BSwap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */