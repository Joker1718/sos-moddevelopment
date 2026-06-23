/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategories;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GScrollRows;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class BlueprintList
/*     */   extends GuiSection
/*     */ {
/*  27 */   private RoomCategories.RoomCategoryMain catCurrent = (RoomCategories.RoomCategoryMain)(SETT.ROOMS()).CATS.MAINS.get(0);
/*  28 */   private GuiSection list = new GuiSection();
/*     */ 
/*     */   
/*     */   BlueprintList(int height) {
/*  32 */     CatButt first = null;
/*     */     
/*  34 */     for (RoomCategories.RoomCategoryMain m : (SETT.ROOMS()).CATS.MAINS) {
/*  35 */       CatButt b = new CatButt(m);
/*  36 */       b.add((SPRITE)m.icon, 0, 0);
/*  37 */       addToCat((GuiSection)b, m);
/*  38 */       b.pad(8, 8);
/*     */       
/*  40 */       RENDEROBJ list = makeList(m, height - b.body().height() - 8);
/*     */       
/*  42 */       if (list != null) {
/*     */         
/*  44 */         b.list = list;
/*  45 */         if (first == null) {
/*  46 */           first = b;
/*     */         }
/*  48 */         addRightC(0, (RENDEROBJ)b);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     if (first == null) {
/*     */       return;
/*     */     }
/*  58 */     this.list.add(first.list);
/*  59 */     addRelBody(4, DIR.S, (RENDEROBJ)this.list);
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(RoomCategories.RoomCategoryMain m, RENDEROBJ list) {
/*  64 */     int x1 = this.list.body().x1();
/*  65 */     int y1 = this.list.body().y1();
/*  66 */     this.list.clear();
/*  67 */     this.list.add(list);
/*  68 */     this.list.body().moveX1Y1(x1, y1);
/*  69 */     this.catCurrent = m;
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ makeList(RoomCategories.RoomCategoryMain cat, int height) {
/*  74 */     ArrayListGrower<RENDEROBJ> rows = new ArrayListGrower();
/*  75 */     final ArrayListGrower<RoomBlueprintIns<?>> rooms = new ArrayListGrower();
/*  76 */     for (RoomCategorySub roomCategorySub : cat.subs) {
/*     */       
/*  78 */       for (RoomBlueprintImp p : roomCategorySub.rooms()) {
/*  79 */         if (p instanceof RoomBlueprintIns && 
/*  80 */           p.isAvailable(SETT.ENV().climate())) {
/*  81 */           rooms.add(p);
/*  82 */           RENDEROBJ r = row((RoomBlueprintIns)p);
/*  83 */           if (r != null) {
/*  84 */             rows.add(r);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     for (RoomBlueprintImp p : cat.misc.rooms()) {
/*  95 */       if (p instanceof RoomBlueprintIns && 
/*  96 */         p.isAvailable(SETT.ENV().climate())) {
/*  97 */         rooms.add(p);
/*  98 */         RENDEROBJ r = row((RoomBlueprintIns)p);
/*  99 */         if (r != null) {
/* 100 */           rows.add(r);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     if (rows.size() == 0)
/* 106 */       return null; 
/* 107 */     GScrollRows s = new GScrollRows((Iterable)rows, height)
/*     */       {
/*     */         protected boolean passesFilter(int i, RENDEROBJ o) {
/* 110 */           return UIPanelUtil.BlueprintList.this.passes((RoomBlueprintIns)rooms.get(i));
/*     */         }
/*     */       };
/* 113 */     return (RENDEROBJ)s.view();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract RENDEROBJ row(RoomBlueprintIns<?> paramRoomBlueprintIns);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addToCat(GuiSection s, RoomCategories.RoomCategoryMain cat) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void hoverCat(GBox b, RoomCategories.RoomCategoryMain cat) {
/* 133 */     b.title(cat.name);
/*     */   }
/*     */   
/*     */   private class CatButt
/*     */     extends GButt.BSection {
/*     */     RENDEROBJ list;
/*     */     private final RoomCategories.RoomCategoryMain m;
/*     */     
/*     */     CatButt(RoomCategories.RoomCategoryMain m) {
/* 142 */       this.m = m;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 147 */       if (hovered() == null || !(hovered() instanceof snake2d.util.gui.clickable.CLICKABLE)) {
/* 148 */         UIPanelUtil.BlueprintList.this.catCurrent = this.m;
/* 149 */         UIPanelUtil.BlueprintList.this.set(this.m, this.list);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 155 */       UIPanelUtil.BlueprintList.this.hoverCat((GBox)text, this.m);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 161 */       selectedSet((UIPanelUtil.BlueprintList.this.catCurrent == this.m));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean passes(RoomBlueprintIns<?> blue) {
/* 166 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIPanelUtil$BlueprintList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */