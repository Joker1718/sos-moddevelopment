/*     */ package view.sett.ui.bottom;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.keyboard.KeyPage;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ final class Delete
/*     */   extends SPanel {
/*     */   protected Delete() {
/*  19 */     CharSequence name = (SETT.JOBS()).tool_remove_smartl.name();
/*     */     
/*  21 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  25 */           (VIEW.inters()).popup.close();
/*  26 */           (VIEW.s()).tools.place((PLACABLE)(SETT.JOBS()).tool_remove_smartl);
/*     */         }
/*     */       };
/*  29 */     BButt bButt5 = new BButt((SETT.JOBS()).tool_remove_smartl.getIcon(), name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  33 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  38 */           (SETT.JOBS()).tool_remove_smartl.hoverDesc((GBox)text);
/*     */         }
/*     */       };
/*     */     
/*  42 */     CLICKABLE cLICKABLE5 = KeyButt.wrap(a, (CLICKABLE)bButt5, (KeyPage)KEYS.SETT(), "REMOVE_SMART", name, "");
/*  43 */     cLICKABLE5 = SearchToolPanel.add(cLICKABLE5, name, "");
/*  44 */     addDownC(0, (RENDEROBJ)cLICKABLE5);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     name = (SETT.JOBS()).tool_remove_all.name();
/*     */     
/*  51 */     a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  55 */           (VIEW.inters()).popup.close();
/*  56 */           (VIEW.s()).tools.place((PLACABLE)(SETT.JOBS()).tool_remove_all);
/*     */         }
/*     */       };
/*  59 */     BButt bButt4 = new BButt((SETT.JOBS()).tool_remove_all.getIcon(), name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  63 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  68 */           (SETT.JOBS()).tool_remove_all.hoverDesc((GBox)text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  73 */     CLICKABLE cLICKABLE4 = KeyButt.wrap(a, (CLICKABLE)bButt4, (KeyPage)KEYS.SETT(), "REMOVE_ALL", name, "");
/*  74 */     cLICKABLE4 = SearchToolPanel.add(cLICKABLE4, name, "");
/*  75 */     addDownC(0, (RENDEROBJ)cLICKABLE4);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     name = (SETT.JOBS()).clearss.road.placer().name();
/*     */     
/*  82 */     a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  86 */           (VIEW.inters()).popup.close();
/*  87 */           (VIEW.s()).tools.place((PLACABLE)(SETT.JOBS()).clearss.road.placer());
/*     */         }
/*     */       };
/*  90 */     BButt bButt3 = new BButt((SETT.JOBS()).clearss.road.placer().getIcon(), name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  94 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  99 */           (SETT.JOBS()).clearss.road.placer().hoverDesc((GBox)text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 104 */     CLICKABLE cLICKABLE3 = KeyButt.wrap(a, (CLICKABLE)bButt3, (KeyPage)KEYS.SETT(), "REMOVE_ROADS", name, "");
/* 105 */     cLICKABLE3 = SearchToolPanel.add(cLICKABLE3, name, "");
/* 106 */     addDownC(0, (RENDEROBJ)cLICKABLE3);
/*     */ 
/*     */ 
/*     */     
/* 110 */     name = (SETT.JOBS()).tool_clear.name();
/*     */     
/* 112 */     a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 116 */           (VIEW.inters()).popup.close();
/* 117 */           (VIEW.s()).tools.place((PLACABLE)(SETT.JOBS()).tool_clear);
/*     */         }
/*     */       };
/* 120 */     BButt bButt2 = new BButt((SETT.JOBS()).tool_clear.getIcon(), name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 124 */           a.exe();
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 128 */           (SETT.JOBS()).tool_clear.hoverDesc((GBox)text);
/*     */         }
/*     */       };
/*     */     
/* 132 */     CLICKABLE cLICKABLE2 = KeyButt.wrap(a, (CLICKABLE)bButt2, (KeyPage)KEYS.SETT(), "REMOVE_JOB", name, "");
/* 133 */     cLICKABLE2 = SearchToolPanel.add(cLICKABLE2, name, "");
/* 134 */     addDownC(0, (RENDEROBJ)cLICKABLE2);
/*     */ 
/*     */ 
/*     */     
/* 138 */     name = (SETT.ROOMS()).DELETE.name();
/* 139 */     a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 143 */           (VIEW.inters()).popup.close();
/* 144 */           (VIEW.s()).tools.place((PLACABLE)(SETT.ROOMS()).DELETE);
/*     */         }
/*     */       };
/* 147 */     BButt bButt1 = new BButt((SETT.ROOMS()).DELETE.getIcon(), name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 151 */           a.exe();
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 155 */           (SETT.ROOMS()).DELETE.hoverDesc((GBox)text);
/*     */         }
/*     */       };
/*     */     
/* 159 */     CLICKABLE cLICKABLE1 = KeyButt.wrap(a, (CLICKABLE)bButt1, (KeyPage)KEYS.SETT(), "REMOVE_ROOM", name, "");
/* 160 */     cLICKABLE1 = SearchToolPanel.add(cLICKABLE1, name, "");
/* 161 */     addDownC(0, (RENDEROBJ)cLICKABLE1);
/*     */ 
/*     */     
/* 164 */     pad(3, 8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\Delete.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */