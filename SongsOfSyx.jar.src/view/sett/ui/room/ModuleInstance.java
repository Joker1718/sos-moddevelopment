/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class ModuleInstance
/*     */   implements Modules.ModuleMaker
/*     */ {
/*  29 */   private static CharSequence ¤¤ACTIVATE = "¤Activate";
/*  30 */   private static CharSequence ¤¤DEACTIVATE = "¤Deactivate";
/*  31 */   private static CharSequence ¤¤UNREACHABLE = "¤Room is not reachable and will not work properly. Make sure there is a clear path to your throne.";
/*  32 */   private static CharSequence ¤¤DEACTIVATED = "¤Deactivated!";
/*  33 */   private static CharSequence ¤¤boost = "Average boost from technology, race, and room properties of all your subjects working in this profession.";
/*     */   static {
/*  35 */     D.ts(ModuleInstance.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModuleInstance(Init init) {}
/*     */ 
/*     */   
/*     */   public void make(RoomBlueprint p, LISTE<UIRoomModule> l) {
/*  43 */     if (p instanceof RoomBlueprintIns)
/*  44 */       l.add(new I((RoomBlueprintIns)p)); 
/*     */   }
/*     */   
/*     */   private final class I
/*     */     extends UIRoomModule
/*     */   {
/*     */     RoomBlueprintIns<?> blue;
/*     */     
/*     */     I(RoomBlueprintIns<?> blue) {
/*  53 */       this.blue = blue;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/*  59 */       if (this.blue.employment() != null || this.blue == (SETT.ROOMS()).DUMP) {
/*  60 */         appliers.add(new UIRoomBulkApplier(ModuleInstance.¤¤ACTIVATE)
/*     */             {
/*     */               protected void apply(RoomInstance t)
/*     */               {
/*  64 */                 t.activate(true);
/*     */               }
/*     */             });
/*  67 */         appliers.add(new UIRoomBulkApplier(ModuleInstance.¤¤DEACTIVATE)
/*     */             {
/*     */               protected void apply(RoomInstance t)
/*     */               {
/*  71 */                 t.activate(false);
/*     */               }
/*     */             });
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/*  79 */       if (this.blue.bonus() == null) {
/*     */         return;
/*     */       }
/*  82 */       GStat s = new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  86 */             GFORMAT.f1(text, (SETT.RECIPES()).player.boost(ModuleInstance.I.this.blue.bonus()), (ModuleInstance.I.this.blue.bonus()).baseValue);
/*     */           }
/*     */         };
/*     */       
/*  90 */       GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)s)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  94 */             (VIEW.UI()).tech.activate();
/*  95 */             (VIEW.UI()).tech.filter(ModuleInstance.I.this.blue.info.name);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 100 */             text.text(ModuleInstance.¤¤boost);
/*     */ 
/*     */             
/* 103 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */       
/* 107 */       b.icon((SPRITE)(this.blue.bonus()).icon);
/* 108 */       b.body.incrW(48.0D);
/*     */       
/* 110 */       icons.add((RENDEROBJ)b);
/*     */       
/* 112 */       super.appendManageScr(icons, text, extra);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox box, Room room, int rx, int ry) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/* 124 */       RoomInstance i = (RoomInstance)room;
/* 125 */       if (!i.reachable())
/* 126 */         errors.add(ModuleInstance.¤¤UNREACHABLE); 
/* 127 */       if (!i.active())
/* 128 */         errors.add(ModuleInstance.¤¤DEACTIVATED); 
/*     */     }
/*     */     
/*     */     public void appendPanel(GuiSection section, GETTER<RoomInstance> get, int x1, int y1) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */