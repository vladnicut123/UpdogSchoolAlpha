package com.updog.greencap.updogschoolalpha.helperClass;

//protected class myDragEventListener implements View.OnDragListener {
//
//    @Override
//    public boolean onDrag(View v, DragEvent event) {
//        final int action = event.getAction();
//
//        switch(action) {
//            case DragEvent.ACTION_DRAG_STARTED:
//                if(event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
//                    v.invalidate();
//                    return true;
//                }
//                return false;
//
//            case DragEvent.ACTION_DRAG_ENTERED:
//                v.invalidate();
//                return true;
//
//            case DragEvent.ACTION_DRAG_LOCATION:
//                return true;
//
//            case DragEvent.ACTION_DRAG_EXITED:
//                v.invalidate();
//                return true;
//
//            case DragEvent.ACTION_DROP:
//                ClipData.Item item = event.getClipData().getItemAt(0);
//                dragData = item.getText();
//                Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_SHORT);
//                v.invalidate();
//                return true;
//
//            case DragEvent.ACTION_DRAG_ENDED:
//                v.invalidate();
//                if(event.getResult()) {
//                    Toast.makeText(getApplicationContext(), "The drop was handled ", Toast.LENGTH_LONG);
//                } else {
//                    Toast.makeText(, "The drop was not handled", Toast.LENGTH_LONG);
//                }
//                return true;
//
//            default:
//                    Log.e("Drag drop exmaple", "unknown message received");
//
//
//        }
//        return false;
//    }
//}
