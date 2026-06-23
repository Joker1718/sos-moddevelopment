/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomFinderHaser;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
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
/*     */ 
/*     */ 
/*     */ final class I
/*     */   extends UIRoomModule
/*     */ {
/*     */   private final RoomService.ROOM_SERVICE_HASER p;
/*     */   
/*     */   I(RoomService.ROOM_SERVICE_HASER p) {
/*  77 */     this.p = p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendManageScr(GGrid grid, GGrid text, GuiSection sExta) {
/*  83 */     if (!(this.p instanceof settlement.room.service.module.ROOM_SPECTATOR.ROOM_SPECTATOR_HASER)) {
/*     */ 
/*     */ 
/*     */       
/*  87 */       SPRITE.Imp imp = new SPRITE.Imp(58, 14)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  91 */             double d = 1.0D - ModuleService.I.this.p.service().load();
/*  92 */             GMeter.render(r, GMeter.C_REDGREEN, d, X1, X2, Y1, Y2);
/*     */           }
/*     */         };
/*     */       
/*  96 */       GHeader.HeaderHorizontal headerHorizontal = new GHeader.HeaderHorizontal((SPRITE)(SPRITES.icons()).s.citizen, (SPRITE)imp)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 100 */             GBox b = (GBox)text;
/* 101 */             b.title(ModuleService.¤¤USAGE);
/*     */             
/* 103 */             b.textLL(ModuleService.¤¤Load);
/* 104 */             b.tab(6);
/* 105 */             b.add((SPRITE)GFORMAT.percInv(b.text(), ModuleService.I.this.p.service().load()));
/* 106 */             b.NL();
/* 107 */             b.text(ModuleService.¤¤USAGE_DESC);
/* 108 */             b.NL(8);
/*     */             
/* 110 */             b.textL(ModuleService.¤¤AVAILABLE);
/* 111 */             b.add((SPRITE)GFORMAT.i(b.text(), ModuleService.I.this.p.service().available()));
/* 112 */             b.NL();
/* 113 */             b.textL(ModuleService.¤¤TOTAL);
/* 114 */             b.add((SPRITE)GFORMAT.i(b.text(), ModuleService.I.this.p.service().total()));
/*     */             
/* 116 */             b.NL(8);
/* 117 */             b.textLL(ModuleService.¤¤Capacity);
/* 118 */             b.tab(6);
/* 119 */             b.add((SPRITE)GFORMAT.i(b.text(), (int)(ModuleService.I.this.p.service().total() * ModuleService.I.this.p.service().totalMultiplier())));
/* 120 */             b.NL();
/* 121 */             b.text(ModuleService.¤¤CapacityD);
/*     */             
/* 123 */             b.NL(8);
/* 124 */             b.textLL(ModuleService.¤¤RADIUS);
/* 125 */             b.add((SPRITE)GFORMAT.i(b.text(), (ModuleService.I.this.p.service()).radius));
/* 126 */             b.NL();
/* 127 */             b.text(ModuleService.¤¤RADIUSD);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 132 */       grid.add((RENDEROBJ)headerHorizontal);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 137 */     if (this.p instanceof RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER)
/*     */     {
/* 139 */       grid.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text) {
/* 142 */               RoomServiceAccess a = ((RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER)ModuleService.I.this.p).service();
/* 143 */               GFORMAT.perc(text, a.cityAccess());
/*     */             }
/* 145 */           }).hh((SPRITE)(SPRITES.icons()).s.arrowUp).hoverInfoSet(ModuleService.¤¤ACCESS));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendButt(GuiSection s, final GETTER<RoomInstance> ins) {
/* 161 */     DOUBLE d = new DOUBLE()
/*     */       {
/*     */         public double getD()
/*     */         {
/* 165 */           return 1.0D - ((ROOM_SERVICER)ins.get()).service().load();
/*     */         }
/*     */       };
/*     */     
/* 169 */     s.addRelBody(16, DIR.E, (SPRITE)(SPRITES.icons()).s.human);
/*     */     
/* 171 */     s.addRightC(2, (SPRITE)new GMeter.GMeterSprite(GMeter.C_REDGREEN, d, 48, 12));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box, Room room, int rx, int ry) {
/* 179 */     ROOM_SERVICER i = (ROOM_SERVICER)room;
/* 180 */     box.textL(ModuleService.¤¤AVAILABLE).add((SPRITE)GFORMAT.iofkInv(box.text(), i.service().available(), i.service().total()));
/* 181 */     box.NL();
/* 182 */     if (this.p instanceof settlement.room.service.module.ROOM_SPECTATOR.ROOM_SPECTATOR_HASER)
/*     */       return; 
/* 184 */     box.textL(ModuleService.¤¤Load);
/* 185 */     box.add((SPRITE)GFORMAT.percInv(box.text(), i.service().load()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/* 190 */     if (((ROOM_SERVICER)room).service().available() == 0) {
/* 191 */       errors.add(ModuleService.¤¤NO);
/*     */     }
/*     */   }
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
/*     */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 211 */     SPRITE.Imp imp = new SPRITE.Imp(48, 16)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 215 */           if (((RoomInstance)get.get()).blueprintI() instanceof RoomService.ROOM_SERVICE_HASER) {
/* 216 */             SETT.OVERLAY().service((RoomFinderHaser)((RoomInstance)get.get()).blueprintI());
/*     */           }
/*     */           
/* 219 */           double d = 1.0D - ModuleService.I.this.g(get).service().load();
/* 220 */           GMeter.render(r, GMeter.C_REDGREEN, d, X1, X2, Y1, Y2);
/*     */         }
/*     */       };
/*     */     
/* 224 */     GHeader.HeaderHorizontal headerHorizontal = new GHeader.HeaderHorizontal(ModuleService.¤¤USAGE, (SPRITE)imp)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 227 */           RoomServiceInstance i = ModuleService.I.this.g(get).service();
/* 228 */           GBox b = (GBox)text;
/*     */           
/* 230 */           b.textLL(ModuleService.¤¤Load);
/* 231 */           b.tab(6);
/* 232 */           b.add((SPRITE)GFORMAT.perc(b.text(), ModuleService.I.this.g(get).service().load()));
/* 233 */           b.NL();
/* 234 */           text.text(ModuleService.¤¤USAGE_DESC);
/* 235 */           text.NL(8);
/*     */ 
/*     */           
/* 238 */           b.textL(ModuleService.¤¤AVAILABLE);
/* 239 */           b.tab(6);
/* 240 */           text.add((SPRITE)GFORMAT.i(b.text(), i.available()));
/* 241 */           text.NL();
/* 242 */           b.textL(ModuleService.¤¤USED);
/* 243 */           b.tab(6);
/* 244 */           text.add((SPRITE)GFORMAT.i(b.text(), (i.total() - i.available())));
/* 245 */           text.NL();
/*     */           
/* 247 */           if (get.get() instanceof RoomInstance && ((RoomInstance)get.get()).blueprintI().employment() != null) {
/* 248 */             b.textL(ModuleService.¤¤NEEDS);
/* 249 */             b.tab(6);
/* 250 */             text.add((SPRITE)GFORMAT.i(b.text(), (i.total() - i.available() - i.reserved())));
/* 251 */             text.NL();
/*     */           } 
/*     */           
/* 254 */           b.textL(ModuleService.¤¤TOTAL);
/* 255 */           b.tab(6);
/* 256 */           text.add((SPRITE)GFORMAT.i(b.text(), i.total()));
/* 257 */           b.NL(8);
/*     */           
/* 259 */           b.textL(ModuleService.¤¤QUALITY);
/* 260 */           b.tab(6);
/* 261 */           text.add((SPRITE)GFORMAT.perc(b.text(), ModuleService.I.this.g(get).quality()));
/* 262 */           b.NL(8);
/*     */           
/* 264 */           b.textLL(ModuleService.¤¤Capacity);
/* 265 */           b.tab(6);
/* 266 */           text.add((SPRITE)GFORMAT.i(b.text(), (int)(i.total() * ModuleService.I.this.p.service().totalMultiplier())));
/* 267 */           b.NL();
/* 268 */           b.text(ModuleService.¤¤CapacityD);
/*     */           
/* 270 */           b.NL(8);
/* 271 */           b.textLL(ModuleService.¤¤RADIUS);
/* 272 */           b.add((SPRITE)GFORMAT.i(b.text(), (ModuleService.I.this.p.service()).radius));
/* 273 */           b.NL();
/* 274 */           b.text(ModuleService.¤¤RADIUSD);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 279 */     section.addRelBody(8, DIR.S, (RENDEROBJ)headerHorizontal);
/*     */   }
/*     */ 
/*     */   
/*     */   private ROOM_SERVICER g(GETTER<RoomInstance> g) {
/* 284 */     return (ROOM_SERVICER)g.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleService$I.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */